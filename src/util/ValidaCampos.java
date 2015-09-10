package util;
public class ValidaCampos {
    public static boolean validaAlfabetico (String alfabetico){
        return alfabetico.matches("\\p{Upper}[\\p{IsLatin}][ ]+");
    }
    public static boolean validaCpf (String cpf){
        boolean retorno = false;
        if(cpf.matches("\\p{Digit}{3,3}\\.\\p{Digit}{3,3}\\.\\p{Digit}{3,3}\\-\\p{Digit}{2,2}")){
            cpf = cpf.replace(".", "");
            cpf = cpf.replace("-", "");
            int soma =0;
            for(int i=0;i<9;i++){
                soma+= Integer.valueOf(new Character(cpf.charAt(i)).toString())*(10-i);
            }
            int dv1 = soma *10%11;
            if(dv1==10 || dv1==11)
                dv1=0;
            if(dv1==Integer.valueOf(new Character(cpf.charAt(9)).toString())){
                soma = 0;
                for(int i=0; i<10;i++){
                    soma+= Integer.valueOf(new Character(cpf.charAt(i)).toString())*(11-i);
                }
                int dv2 = soma *10%11;
                if(dv2==10 || dv2==11)
                    dv2=0;
                if(dv2==Integer.valueOf(new Character(cpf.charAt(10)).toString()))
                    retorno = true;
            }
                else retorno = false;
        }
                return retorno;
    }
    public static boolean validaNumerico (String numerico){
        return numerico.matches("\\p{Digit}+");
    }
    public static boolean validaAlfaNumerico (String alfanumerico){
        return alfanumerico.matches("\\p{upper}[\\p{isLatin}\\p{Alfnum}[ ][,-]]+");
    }
    public static boolean validaEmail (String email){
        return email.matches("[\\p{Alnum}\\.\\_\\-]+@[\\p{Alnum}\\.\\_\\-]+");
    }
}
