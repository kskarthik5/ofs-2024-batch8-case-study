import { Customer } from "../types/Customer";
import { LoginResponse } from "../types/LoginResponse";

const url="http://localhost:8081/api/customer/";
async function getAll():Promise<Customer[]>{
        return await fetch(url+"getAll",{
            method:'GET'
        }).then(async (res:Response) =>await res.json()).then(async (res:Customer[])=>{
            return res
        });
}
async function login(username:string,password:string):Promise<LoginResponse>{
    return await fetch(url+"login",{
        method:'POST',
        headers:{
            'Content-Type':'application/json'
        },
        body:JSON.stringify({username,password})
    }).then(async (res:Response) =>await res.json()).then(async (res:LoginResponse)=>{
        return res
    });
}
async function register(customer:Customer):Promise<Customer>{
    return await fetch(url+"register",{
        method:'POST',
        headers:{
            'Content-Type':'application/json'
        },
        body:JSON.stringify(customer)
    }).then(async (res:Response) =>await res.json()).then(async (res:Customer)=>{
        return res
    });
}
export default {
    login,
    register,
    getAll
}