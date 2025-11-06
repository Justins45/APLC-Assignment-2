user_list = {
        "user_id": "117",
        "user_name": "jason",
        "email": "jason@compthinking.ca",
        "password": "password117",
        "role": "administrator",
        "login_attempts_remaining": 4
    }, {
        "user_id": "217",
        "user_name": "vivek",
        "email": "vivek@compthinking.ca",
        "password": "password217",
        "role": "administrator",
        "login_attempts_remaining": 4
    }, {
        "user_id": "317",
        "user_name": "justin",
        "email": "justin@compthinking.ca",
        "password": "password317",
        "role": "viewer",
        "login_attempts_remaining": 4
    }, {
        "user_id": "417",
        "user_name": "jazmine",
        "email": "jazmine@compthinking.ca",
        "password": "password417",
        "role": "editor",
        "login_attempts_remaining": 4
    }


# user login function
def login():    

    login_attempts = 4
    

    Username = input("Enter your username:")
    Password = input("Enter your password:")
        
    authentication = False
        
    found_user = None
        
    for users in user_list:
        

        if  Username == users["user_name"] and  Password == users["password"]:
                
            authentication = True
            print("login sccessful! Welcome," + Username + "!" )
            break
            
        # else:
        #    print("Invalid Username or Password")
            
print(user_list[2])      

# login()




# user file access function


