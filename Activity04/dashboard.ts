import * as AccUtils from "../accUtils";
import 'ojs/ojknockout';
import 'ojs/ojtable';import * as ko from "knockout";
import { RESTDataProvider } from 'ojs/ojrestdataprovider';
import { Account } from "../types/Account";
import { Customer } from "../types/Customer";
import loggedInCustomerDataProvider from "../dataProviders/loggedInCustomerDataProvider";
class DashboardViewModel {
  dataprovider : RESTDataProvider<Account['accountId'],Account>;
  customer:Customer|null;
  constructor(){
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