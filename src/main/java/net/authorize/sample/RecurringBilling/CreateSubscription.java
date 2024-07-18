package net.authorize.sample.RecurringBilling;

import java.math.BigDecimal;
import java.math.RoundingMode;

import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import net.authorize.Environment;
import net.authorize.api.contract.v1.ANetApiResponse;
import net.authorize.api.contract.v1.ARBCreateSubscriptionRequest;
import net.authorize.api.contract.v1.ARBCreateSubscriptionResponse;
import net.authorize.api.contract.v1.ARBSubscriptionType;
import net.authorize.api.contract.v1.ARBSubscriptionUnitEnum;
import net.authorize.api.contract.v1.CreditCardType;
import net.authorize.api.contract.v1.MerchantAuthenticationType;
import net.authorize.api.contract.v1.MessageTypeEnum;
import net.authorize.api.contract.v1.NameAndAddressType;
import net.authorize.api.contract.v1.PaymentScheduleType;
import net.authorize.api.contract.v1.PaymentType;
import net.authorize.api.controller.ARBCreateSubscriptionController;
import net.authorize.api.controller.base.ApiOperationBase;

public class CreateSubscription {

    public static ANetApiResponse run(String apiLoginId, String transactionKey, short intervalLength, Double amount) {
        //Common code to set for all requests
        ApiOperationBase.setEnvironment(Environment.SANDBOX);
        MerchantAuthenticationType merchantAuthenticationType  = new MerchantAuthenticationType() ;
        merchantAuthenticationType.setName(apiLoginId);
        merchantAuthenticationType.setTransactionKey(transactionKey);
        ApiOperationBase.setMerchantAuthentication(merchantAuthenticationType);

        // Set up payment schedule
        PaymentScheduleType schedule = new PaymentScheduleType();
        PaymentScheduleType.Interval interval = new PaymentScheduleType.Interval();
        interval.setLength(intervalLength);
        interval.setUnit(ARBSubscriptionUnitEnum.DAYS);
        schedule.setInterval(interval);
        
        try {
          XMLGregorianCalendar startDate = DatatypeFactory.newInstance().newXMLGregorianCalendar();
          startDate.setDay(30);
          startDate.setMonth(12);
        }
    
        
    }}

