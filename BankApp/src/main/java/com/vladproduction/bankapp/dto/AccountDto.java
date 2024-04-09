package com.vladproduction.bankapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created by vladproduction on 08-Apr-24
 */

//for automatic constructor, getters & setters
@Data
//mapToAccountDto able to create accountDto now
@AllArgsConstructor
public class AccountDto {

    private Long id;
    private String accountHolderName;
    private double balance;

}
