
function pwd(input,img) {
    var num=0;

    img.addEventListener('click',function (){
        if (num==0){
            img.src='images/eye-show.png'
            input.type='text'
            num=1;
        }else{
            img.src='images/eye-hidden.png'
            input.type='password'
            num=0;
        }


    })
}


