/**
 * @license
 * Copyright (c) 2014, 2024, Oracle and/or its affiliates.
 * Licensed under The Universal Permissive License (UPL), Version 1.0
 * as shown at https://oss.oracle.com/licenses/upl/
 * @ignore
 */

import 'ojs/ojknockout';
import 'oj-c/text-area';
import 'oj-c/input-date-mask';
import 'oj-c/input-date-text';
import 'oj-c/input-month-mask';
import 'oj-c/input-number';
import 'oj-c/input-text';
import 'oj-c/input-password';
import 'oj-c/input-sensitive-text';
import 'oj-c/radioset';
import 'oj-c/select-multiple';
import 'oj-c/select-single';
import 'oj-c/form-layout';
import 'oj-c/checkboxset';
import 'oj-c/checkbox';
import 'oj-c/collapsible';
import "oj-c/button";
import Message = require('ojs/ojmessaging');
import { CInputMonthMaskElement } from 'oj-c/input-month-mask';
import * as ko from "knockout";
import * as AccUtils from "../accUtils";
import customerService from '../services/customerService';
class RegisterViewModel {
  firstNameValue: ko.Observable<string>;
  lastNameValue: ko.Observable<string>;
  usernameValue: ko.Observable<string>;
  passwordValue: ko.Observable<string>;
  confirmPasswordValue: ko.Observable<string>;
  phoneNumberValue: ko.Observable<number>;
  constructor() {
    this.phoneNumberValue = ko.observable(0);
    this.firstNameValue = ko.observable("");
    this.lastNameValue = ko.observable("");
    this.usernameValue = ko.observable("");
    this.confirmPasswordValue = ko.observable("");
    this.passwordValue = ko.observable("");
  }
  handleRegisterSubmit = async () => {
    if (this.passwordValue() != this.confirmPasswordValue())
      alert("Passwords do not match")
    else {
      let res = await customerService.register({
        firstName: this.firstNameValue(),
        lastName: this.lastNameValue(),
        username: this.usernameValue(),
        password: this.passwordValue(),
        phone: this.phoneNumberValue()
      });
      if (res)
        alert("success")
      else
        alert("failed")
    }
  }
  /**
   * Optional ViewModel method invoked after the View is inserted into the
   * document DOM.  The application can put logic that requires the DOM being
   * attached here.
   * This method might be called multiple times - after the View is created
   * and inserted into the DOM and after the View is reconnected
   * after being disconnected.
   */
  connected(): void {
    AccUtils.announce("Incidents page loaded.");
    document.title = "Incidents";
    // implement further logic if needed
  }

  /**
   * Optional ViewModel method invoked after the View is disconnected from the DOM.
   */
  disconnected(): void {
    // implement if needed
  }

  /**
   * Optional ViewModel method invoked after transition to the new View is complete.
   * That includes any possible animation between the old and the new View.
   */
  transitionCompleted(): void {
    // implement if needed
  }
}

export = RegisterViewModel;
