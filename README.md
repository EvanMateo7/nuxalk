# nuxalk
SOEN 343 - Team Nuxalk - Medical Billing Software

How to deploy locally?

Prerequisite:
- An instance of mysql
- The credentials used by the application to connect to mysql instance can be found on the application.properties file.
- A database with name 'test' need to be created in order for the local deployment to work. It does not create itself

To be able to access any protected path in the application, you need to access the *localhost*/register endpoint, register a user
then you can connect to all protected endpoints using the credentials of the user you registered.

