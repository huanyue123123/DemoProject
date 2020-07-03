export function login(user){
    let username = user.username;
    let password = user.password;
    console.log(user);
    if(username&&password){
        return "success";
    }else{
      return "error";
    }
}
