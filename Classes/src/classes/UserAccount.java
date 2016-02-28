
package classes;
import java.util.UUID;

public class UserAccount {
    //Variables:
    private String userAccountID;
    private String username;
    private String password;
    private String email;
    

    //Methods:
        public String getUserAccountID(){
            return userAccountID;
        }
        public void setUserAccountID(String userID){
            userAccountID = userID;
        }
        public String getUsername(){
            return username;
        }
        public void setUsername(String u) {
            username = u;
        }
        public String getPassword(){
            return password;
        }
        public void setPassword(String p){
            password = p;
        }
        public String getEmail(){
            return email;
        }
        public void setEmail(String e){
            email = e;
        }
        
        //Constructors: 
        private UserAccount(){
            userAccountID = UUID.randomUUID().toString();
            username = "";
            password = "";
            email = "";
        }

        private UserAccount(String u, String p, String e) {
            userAccountID = UUID.randomUUID().toString();
            setUsername(u);
            setPassword(p);
            setEmail(e);
        }
        public static UserAccount getInstance(){
            
            return new UserAccount();
        }
        
        public static UserAccount getInstance(String u, String p, String e){
            
            return new UserAccount(u,p,e);
        }
        
        public boolean authenticate (String u, String p){
            if(username.equals(u) && password.equals(p)){
                return true;
            }
            return false;
        }
        public void load(String key) {
            Database_Load(key);
        }

        public void insert() {
            Database_Insert();
        }

        public void update() {
            Database_Update();
        }

        public void delete() {
            Database_Delete();
        }

        protected void Database_Load(String key) {
        }

        protected void Database_Insert() {
        }

        protected void Database_Update() {
        }

        protected void Database_Delete() {
        }
            }