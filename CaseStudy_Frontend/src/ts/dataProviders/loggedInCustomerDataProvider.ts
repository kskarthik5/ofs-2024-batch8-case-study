import { Customer } from "../types/Customer"

var customer:Customer|null=null
function get():Customer|null{
    return customer;
}
function set(newCustomer:Customer){
    customer=newCustomer;
}
const loggedInCustomerDataProvider={
    get,
    set
};
export default loggedInCustomerDataProvider;