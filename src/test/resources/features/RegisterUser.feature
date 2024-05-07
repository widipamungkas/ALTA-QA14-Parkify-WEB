@RegisterPage

  Feature: Register
    As a User I want to register as role user
    Scenario: Register User
      Given User open the app parkify
      And User click sign up button
      And User click button role user
      When User input "widi pams" as fullname and "redvelvet@gmail.com" as email and "parkify123" as password and click sign up
      And User will see success message "<selamat data sudah terdaftar>"
      Then User will redirected to login page
