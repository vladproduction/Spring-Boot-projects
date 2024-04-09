# bankapp

## RestApi using SpringBoot, JPA, MySql for simple banking app

### project based on:

### 1)database connectivity (settings application.properties)
### 2)create packing structure:
  * entity
  * repository (extends JpaRepository)
  * service (rest api methods)
    * impl (all service layer implementations are here) 
  * dto (for transferring data)
  * mapper (for mapping the data our dto entities)
  * controller (requests layer):
    * createAccount;
    * getAccountById;
    * deposit;
    * withdraw;
    * getAllAccounts;
    * deleteAccount;
### 3)MySql DB
### 4)Postman (http requests)



