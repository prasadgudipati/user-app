Build the project using mvn clean install
start the app using java -jar target/user-app-0.0.1-SNAPSHOT.jar

Rest urls to use

o	public void addUser(User user);
http://localhost:8080/user/updateUser
Type: POST
content-Type: application/json
{"userId":4,"email":"jack4.ma@atworks.com","password":null}

o	public void deletePhone(Long userId, String type);
http://localhost:8080/userPhone/deletePhone/1/HOME
Method: DELETE
content-Type: application/json

o	public void updatePhone(Long userId, String type, String phone);
http://localhost:8080/userPhone/updatePhone
Type: POST
content-Type: application/json
{"id":2,"userId":2,"type":"CELL","phoneNumber":"3014456881","createdBy":"tester2","createdOn":"2013-02-02"}

o	public List<UserHobby> getHobbies(Long userId);
Type: GET
http://localhost:8080/userHobby/getAll

o	public List<User> getUsers();
Type: GET
http://localhost:8080/user/getAll
