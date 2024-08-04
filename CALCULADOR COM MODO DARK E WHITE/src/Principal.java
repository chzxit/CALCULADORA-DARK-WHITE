import java.awt.EventQueue;

public class Principal {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run (){
                try{
                    calculadoraDark frame = new calculadoraDark();
                    //onde a calculadora vai abrir na tela 
                    frame.setLocationRelativeTo(frame);
                    //tirar a barrinha
                    frame.setUndecorated(true);
                    //para a calculadora aparecer
                    frame.setVisible(true);
                    //definir a opacidade da calculadora
                    frame.setOpacity((float)0.99);
                    //definir o titulo da calculadora
                    frame.setTitle("Calculadora ");

                } catch(Exception e){
                    e.printStackTrace();
        
                }
            }
        
       });
    }
}
