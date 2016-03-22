package com.example.fernandofgsf.projetoteste.bo;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

import com.example.fernandofgsf.projetoteste.repository.LoginRepository;
import com.example.fernandofgsf.projetoteste.util.Util;
import com.example.fernandofgsf.projetoteste.validation.LoginValidation;

/**
 * Created by fernando.fgsf on 18/03/2016.
 */
public class LoginBO {

    private LoginRepository loginRepository;

    public LoginBO(Activity activity){
        loginRepository = new LoginRepository(activity);
        loginRepository.popularBD();
    }

    public boolean validarCamposLogin(LoginValidation validation) {
        boolean resultado = true;
//        if(login == null || "".equals(login)){
//            return false;
//        } else if (senha == null || "".equals(senha)){
//            return false;
//        }
        if (validation.getLogin() == null || "".equals(validation.getLogin())) {
            validation.getEdtLogin().setError("Campo Obrigatório!");
            resultado = false;
        }

        if (validation.getSenha() == null || "".equals(validation.getSenha())) {
            validation.getEdtSenha().setError("Campo Obrigatório!");
            resultado = false;
        }

        if (resultado) {
            if (!validation.getLogin().equals("admin") || !validation.getSenha().equals("admin")) {
                Util.showMsgToast(validation.getActivity(), "Login/Senha inválidos!");
                resultado = false;
            } else {
                SharedPreferences.Editor editor = validation.getActivity().getSharedPreferences("pref" ,Context.MODE_PRIVATE).edit();
                editor.putString("login", validation.getLogin());
                editor.putString("senha", validation.getSenha());
                editor.commit();
            }
        }

        return resultado;
    }

    public void deslogar(){

    }

}
