package com.vladproduction.controller;

import com.vladproduction.quoters.Quoter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/quoter")
public class QuoterController {

    private Quoter terminatorQuoter;

    public QuoterController(@Qualifier("terminatorQuoter") Quoter terminatorQuoter) {
        this.terminatorQuoter = terminatorQuoter;
    }

    @GetMapping("/terminatorQuoter")
    public String getTerminatorQuoter(){
//        return terminatorQuoter.sayQuote();
        return null;
    }

    @PostMapping("/terminatorQuoterRepeat")
    public void postTerminatorQuoterRepeat(){
        terminatorQuoter.sayQuoteRepeat();
    }

}
