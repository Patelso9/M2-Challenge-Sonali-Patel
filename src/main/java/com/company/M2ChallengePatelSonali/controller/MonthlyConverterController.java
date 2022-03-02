package com.company.M2ChallengePatelSonali.controller;

import com.company.M2ChallengePatelSonali.exceptions.NotFoundException;
import com.company.M2ChallengePatelSonali.models.Month;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@RestController
public class MonthlyConverterController {
    private static List<Month> monthList = new ArrayList<>(Arrays.asList(
            new Month(1, "January"),
            new Month(2, "February"),
            new Month(3, "March"),
            new Month(4, "April"),
            new Month(5, "May"),
            new Month(6, "June"),
            new Month(7, "July"),
            new Month(8, "August"),
            new Month(9, "September"),
            new Month(10, "October"),
            new Month(11, "November"),
            new Month(12, "December")
    ));

    //    Get month number
    @RequestMapping(value = "/month/{monthNumber}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public Month getMonthByNum(@PathVariable int monthNumber) {
        Month foundMonth = null;

        for (Month month : monthList) {
            if (month.getMonthNumber() == monthNumber) {
                foundMonth = month;
                break;
            }
            if ((month.getMonthNumber() >= 13) || (month.getMonthNumber() <= 0)) {
                throw new NotFoundException("Please enter a number between 1-12");
            }
        }
        return foundMonth;
    }

    ;

    //    Get random month
    @RequestMapping(value = "/randomMonth")
    @ResponseStatus(value = HttpStatus.OK)
    public Month getRandomMonthByNum() {

        Random randomMonthNum = new Random();
        int monthNumGen = randomMonthNum.nextInt(12)+1;

        return monthList.get(monthNumGen);
    }

}