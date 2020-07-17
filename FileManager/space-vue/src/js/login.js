import axios from 'axios';

export function login(user){
    let username = user.username;
    let password = user.password;
    console.log(user);
  axios.post('/user/login', user)
    .then(function (response) {
      console.log(response);
      if(response.data.code == 1){
        alert(21);
        location.href = "homepage/index"
      }
    })
    .catch(function (error) {
      console.log(error);
    });
}
