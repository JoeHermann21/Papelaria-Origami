
(function ($) {
    "use strict";

    /*==================================================================
    [ Focus Contact2 ]*/
    $('.input100').each(function(){
        $(this).on('blur', function(){
            if($(this).val().trim() != "") {
                $(this).addClass('has-val');
            }
            else {
                $(this).removeClass('has-val');
            }
        })    
    })


    /*==================================================================
    [ Validate after type ]*/
    $('.validate-input .input100').each(function(){
        $(this).on('blur', function(){
            if(validate(this) == false){
                showValidate(this);
            }
            else {
                $(this).parent().addClass('true-validate');
            }
        })    
    })

    /*==================================================================
    [ Validate ]*/
    var input = $('.validate-input .input100');

    $('.validate-form').on('submit',function(){
        var check = true;

        for(var i=0; i<input.length; i++) {
            if(validate(input[i]) == false){
                showValidate(input[i]);
                check=false;
            }
        }

        return check;
    });
    
    $('.validate-form .input100').each(function(){
        $(this).focus(function(){
           hideValidate(this);
           $(this).parent().removeClass('true-validate');
        });
    });

    function validate (input) {
        if($(input).attr('type') == 'email' || $(input).attr('name') == 'txtemail' || $(input).attr('name') == 'txtEmail' )  {
            if($(input).val().trim().match(/^([a-zA-Z0-9_\-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([a-zA-Z0-9\-]+\.)+))([a-zA-Z]{1,5}|[0-9]{1,3})(\]?)$/) == null) {
                return false;
            }
        }
        if($(input).attr('type') == 'number' || $(input).attr('name') == 'txtCpfCli')  {
            if($(input).val().trim().match(/(\d{3})(\d{3})(\d{3})(\d{2})/) == null) {
                return false;
            }
        }
         if($(input).attr('type') == 'registro' || $(input).attr('name') == 'reg')  {
            if($(input).val().trim().match(/[-]{0,1}[\d]*[.]{0,1}[\d]+/g) == null) {
                return false;
            }
        }
        if($(input).attr('type') == 'password' || $(input).attr('name') == 'txtsenha' || $(input).attr('name') == 'txtSenha') {
            if($(input).val().trim().match(/^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[$*&@#])[0-9a-zA-Z$*&@#]{8,}$/) == null) {
                return false;
            }
        }
        if((input.valueOf !== document.getElementById("SenhaCli").value) != (input.valueOf !== document.getElementById("repeteSenhaCli").value)){
        input.setCustomValidity('Senha não são iguais, favor repita!');
        }else{
        input.setCustomValidity('');
    }
        
    }
    

    function showValidate(input) {
        var thisAlert = $(input).parent();

        $(thisAlert).addClass('alert-validate');
    }

    function hideValidate(input) {
        var thisAlert = $(input).parent();

        $(thisAlert).removeClass('alert-validate');
    }
    


})(jQuery);