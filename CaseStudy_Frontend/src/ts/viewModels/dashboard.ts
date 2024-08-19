import * as AccUtils from "../accUtils";
import * as ko from "knockout";
import { RESTDataProvider } from 'ojs/ojrestdataprovider';
import { Account } from "../types/Account";
import { Customer } from "../types/Customer";
import loggedInCustomerDataProvider from "../dataProviders/loggedInCustomerDataProvider";
type CardData={
  icon:string,
  title:string,
  description:string
}
class DashboardViewModel {
  dataprovider : RESTDataProvider<Account['accountId'],Account>;
  customer:Customer|null;
  cardData: CardData[];
  constructor(){
    
    this.cardData=[{
      icon:"https://img.icons8.com/?size=100&id=NRnHrVR72mFm&format=png&color=000000",
      title:"Statement",
      description:"Get Statement for your account"
    },
    {
      icon:"https://img.icons8.com/?size=100&id=52882&format=png&color=000000",
      title:"Customer Information",
      description:"Get customer information"
    },
    {
      icon:"https://img.icons8.com/?size=100&id=cA5WKC2QuCXb&format=png&color=000000",
      title:"Transfer Money",
      description:"Send Money across accounts"
    }
    ]
    this.customer=JSON.parse(sessionStorage.getItem('loginData') || '{}');
    this.dataprovider= new RESTDataProvider({
      keyAttributes:"accountId",
      url:'http://localhost:8081/api/account/get',
      transforms:{
        fetchFirst:{
          request:async (options)=>{
            console.log(options);
            const url = new URL(options.url);
            return new  Request(url.href,{
              method:'POST',
              headers:{
                'Content-Type':'application/json'
              },
              body:JSON.stringify({customerId:this.customer?.customerId})
            });
          },
          response:async({body})=>{
            let data = body;
            return {data}
          }
        }
      }
    })
  }
}
export = DashboardViewModel;