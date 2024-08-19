import { Customer } from "./Customer";

export type Account={
    accountId?:number,
    balance?:number,
    minBalance?:number,
	rateOfInterest?:number,
	interestDate?:Date,
	interestPeriod?:number;
	status?:string;
	accountType?:string;
    customer?:Customer;
}