package com.vladproduction.springbootcinemabookingservice.model;

/**
 * describes customer of booking service;
 */

public interface UserModel extends Entity {

    String getName();

    void setName(String name);

    /**
     * User email. UNIQUE.
     */
    String getEmail();

    void setEmail(String email);
}
