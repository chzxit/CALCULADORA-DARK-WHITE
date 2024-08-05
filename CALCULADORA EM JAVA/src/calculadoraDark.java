import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;




   public class calculadoraDark extends JFrame implements ActionListener{

    private JPanel contentPane;
    private JTextField textFieldDisplay;
    private Color corBotao;
    private Color corFundo;
    private Color corTexto;
    private Color corLinha;
    private int y;
    private int x;
    private boolean blackMode = true;




   

    public calculadoraDark(){

        corBotao = new Color(70, 71, 74);
        corTexto = Color.white;
        corFundo = new Color(53, 53, 53);
        corLinha = new Color(53, 53, 53);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 320 , 490);
        contentPane = new JPanel();
        contentPane.setBorder(null);
        contentPane.setBackground(corFundo);
        contentPane.setLayout(null);
        setContentPane(contentPane);

        //movimentar a tela da calculadora
        movimentarTela();
        //para mudar a cor da calculadora. 
        JLabel btnModo = new JLabel();
        //local da imagem
        btnModo.setIcon(new ImageIcon(calculadoraDark.class.getResource("/image/whiteMode.png")));
        btnModo.setBounds(0 , 0 , 40 , 30);
        contentPane.add(btnModo);

        JButton btnFechar = criarBotao("x",  280 , 0 , 40 , 30);
        btnFechar.addActionListener(this);
        contentPane.add(btnFechar);

        textFieldDisplay = new JTextField();
        textFieldDisplay.setBorder(null);
        textFieldDisplay.setEditable(false);
        textFieldDisplay.setFont(new Font("Tahoma", Font.PLAIN, 48));
        textFieldDisplay.setHorizontalAlignment(SwingConstants.RIGHT);
        textFieldDisplay.setText("0");
        textFieldDisplay.setForeground(Color.WHITE);
        textFieldDisplay.setBounds(0, 32, 320, 60);
        textFieldDisplay.setBackground(corFundo);
        contentPane.add(textFieldDisplay);
        textFieldDisplay.setColumns(10);

        JButton btnApagar = criarBotao("C",  0 , 90 , 160 , 80);
        btnApagar.addActionListener(this);
        contentPane.add(btnApagar);

        JButton btnMultiplicacao = criarBotao("*",  160 , 90 , 80 , 80);
        btnMultiplicacao.addActionListener(this);
        contentPane.add(btnMultiplicacao);

        JButton btnDivisao = criarBotao("/",  240 , 90 , 80 , 80);
        btnDivisao.addActionListener(this);
        contentPane.add(btnDivisao);

        JButton btnSubitracao = criarBotao("-",  240 , 170 , 80 , 80);
        btnSubitracao.addActionListener(this);
        contentPane.add(btnSubitracao);

        JButton btnAdicao = criarBotao("+",  240 , 250 , 80 , 80);
        btnAdicao.addActionListener(this);
        contentPane.add(btnAdicao);

        JButton btnIgual = criarBotao("=",  240 , 330 , 80 , 160);
        btnIgual.addActionListener(this);
        contentPane.add(btnIgual);

        JButton btnZero = criarBotao("0",  0 , 410 , 160 , 80);
        btnZero.addActionListener(this);
        contentPane.add(btnZero);

        JButton btnPonto = criarBotao(".",  160 , 410 , 80 , 80);
        btnPonto.addActionListener(this);
        contentPane.add(btnPonto);

        JPanel panelbotoesNumerico = new JPanel();
        panelbotoesNumerico.setBounds(0,170,240,320);
        panelbotoesNumerico.setLayout(new GridLayout (4, 3));
        panelbotoesNumerico.setBorder(null);
        panelbotoesNumerico.setBackground(corFundo);
        panelbotoesNumerico.setOpaque(true);
        
        //vetor de strings, cada elemento representa um botao numerico
        String[] botoesNumericos = {"7", "8", "9", "4", "5", "6", "1", "2", "3"};
        //Esta linha inicia um loop for-each, que percorre cada elemento do array botoesNumericos. Para cada iteração do loop, o elemento atual é armazenado na variável botao.
        for (String botao : botoesNumericos){
            
            JButton btn = new JButton(botao);
            btn.addActionListener(this);
            btn.setHorizontalAlignment(SwingConstants.CENTER);
            btn.setFont(new Font("Tahoma", Font.PLAIN, 36));
            btn.setForeground(corTexto);
            btn.setFocusPainted(false);
            btn.setBackground(corBotao);
            btn.setBorder(new LineBorder(corLinha, 2));
            panelbotoesNumerico.add(btn);
            
        }

        contentPane.add(panelbotoesNumerico);

        for(Component component : contentPane.getComponents()){
            if(component instanceof JButton){
                JButton btn = (JButton)component;
                alterarCorBotao(btn);
            }
             //instanceof é usado para verificar se um objeto é uma instância de uma classe específica ou implementa uma interface específica. Ele retorna um valor booleano
            if(component instanceof JPanel){ //panelBotoes 1 a 9
                for(Component botoesPanel: ((JPanel)component).getComponents()){
                    if(botoesPanel instanceof JButton){
                        JButton btn = (JButton)botoesPanel;
                        alterarCorBotao(btn);
                    }

                }

            }
        }
        //para mudar de preto para branco
          btnModo.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                blackMode = !blackMode;
              if (blackMode) {{
                btnModo.setIcon(new ImageIcon(calculadoraDark.class.getResource("/image/whiteMode.png")));
                corFundo = new Color(53, 53, 53);
                corBotao= new Color(70, 71, 74);;
                corTexto = Color.white;
                corLinha = new Color(53, 53, 53);

                contentPane.setBackground(Color.white);
                panelbotoesNumerico.setBackground(Color.white);
                textFieldDisplay.setBackground(corFundo);
                textFieldDisplay.setForeground(Color.white);

                for(Component component : contentPane.getComponents()){
                    if(component instanceof JButton){
                        JButton btn = (JButton)component;
                       
                        btn.setForeground(corTexto);
                        btn.setBackground(corBotao);
                        btn.setBorder(new LineBorder(corLinha, 2));
                        contentPane.setBackground(corFundo);
                    }
                 //instanceof é usado para verificar se um objeto é uma instância de uma classe específica ou implementa uma interface específica. Ele retorna um valor booleano
                    if(component instanceof JPanel){ //panelBotoes 1 a 9
                        for(Component botoesPanel: ((JPanel)component).getComponents()){
                            if(botoesPanel instanceof JButton){
                                JButton btn = (JButton)botoesPanel;
                                btn.setForeground(corTexto);
                                btn.setBackground(corBotao);
                                btn.setBorder(new LineBorder(corLinha, 2));
                                contentPane.setBackground(corFundo);
                            }
        
                        }
        
                    }
                }
                

              }
                  
              } else {
                btnModo.setIcon(new ImageIcon(calculadoraDark.class.getResource("/image/darkMode.png")));
                corFundo = Color.white;
                corBotao= new Color(204, 204, 204);
                corTexto = new Color(77, 77, 77);
                corLinha = Color.white;
                contentPane.setBackground(Color.white);
                panelbotoesNumerico.setBackground(Color.white);
                textFieldDisplay.setBackground(Color.white);
                textFieldDisplay.setForeground(corTexto);

                for(Component component : contentPane.getComponents()){
                    if(component instanceof JButton){
                        JButton btn = (JButton)component;
                       
                        btn.setForeground(corTexto);
                        btn.setBackground(corBotao);
                        btn.setBorder(new LineBorder(corLinha, 2));
                        contentPane.setBackground(corFundo);
                    }
                     //instanceof é usado para verificar se um objeto é uma instância de uma classe específica ou implementa uma interface específica. Ele retorna um valor booleano
                    if(component instanceof JPanel){ //panelBotoes 1 a 9
                        for(Component botoesPanel: ((JPanel)component).getComponents()){
                            if(botoesPanel instanceof JButton){
                                JButton btn = (JButton)botoesPanel;
                                btn.setForeground(corTexto);
                                btn.setBackground(corBotao);
                                btn.setBorder(new LineBorder(corLinha, 2));
                                contentPane.setBackground(corFundo);
                            }
        
                        }
        
                    }
                }
                

              }
            }
          });  

    }

    private void alterarCorBotao(JButton jButton){
            jButton.addMouseListener(new MouseAdapter() {

                    @Override
                    public void mouseEntered( MouseEvent e){ 
                    jButton.setBackground(corFundo);
                     }

                     @Override
                     public void mouseExited(MouseEvent e){
                        jButton.setBackground(corBotao);
                     }
            });
        }

    private JButton criarBotao(String textoBotao, int x , int y, int width, int height){
        JButton jButton = new JButton(textoBotao);
        jButton.setHorizontalAlignment(SwingConstants.CENTER);
        jButton.setFont(new Font("Tahoma", Font.PLAIN, textoBotao.equalsIgnoreCase("x")? 20 : 36));
        jButton.setForeground(corTexto);
        jButton.setFocusPainted(false);
        jButton.setBackground(corBotao);
        jButton.setBorder(new LineBorder(corLinha, 2));
        jButton.setBounds(x, y, width, height);

        return jButton;
    }

    // metodo para movimentar a tela 
    private void movimentarTela(){
        //MouseMotionListener está sendo adicionado ao contentPane (que é o painel de conteúdo da janela).
        contentPane.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            //O método mouseDragged é sobrescrito para ser chamado quando o mouse é arrastado com um botão pressionado.
            public void mouseDragged(MouseEvent e){
            //setLocation(e.getXOnScreen() - x, e.getYOnScreen() - y); define a nova posição da janela com base no movimento do mouse. x e y são variáveis que armazenam a diferença inicial entre a posição do mouse e a posição da janela, que serão definidas no próximo bloco de código.
                setLocation(e.getXOnScreen() -x , e.getYOnScreen() -y);
            }
        });
        contentPane.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e){
                super.mousePressed(e);
                x = e.getX();
                y = e.getY();
            }
        });
    }

    //back end
    @Override
    public void actionPerformed(ActionEvent e){
        String comando = e.getActionCommand();

        if("=".equals(comando)){
            String expressao = textFieldDisplay.getText();
            double resultado = verficarExpressao(expressao);
            textFieldDisplay.setText(Double.toString(resultado));
        }else if ("c".equalsIgnoreCase(comando)) {
            //limpar display 
            textFieldDisplay.setText("0");
        }else if("x".equalsIgnoreCase(comando)){
            dispose();
        //caso nao seja nenhum dos botoes acima iremos concatenar 
        }else {
                String textoDisplay = textFieldDisplay.getText();
                char lastChar = textoDisplay.charAt(textoDisplay.length()-1);
                 // se for algum dos operados ira entrar nesse if e esse if ira fazer que troque o operador caso o usuario ja tenha clicado em algum operador diferente.
                 // esse -1 significa exeto o ultimo caracter.
                if (isOperador(lastChar) && isOperador(comando.charAt(comando.length()-1))) {
                    textoDisplay = textoDisplay.substring(0, textoDisplay.length()-1);
                    textFieldDisplay.setText(textoDisplay + comando);
                }else{
                    //esse if vai vericar se o texto que tem na calculador e 0.
                    if(textFieldDisplay.getText().equalsIgnoreCase("0")){
                    //se for zero ira passa para vazio esse display para que nao seja concatenado um valor com 0.
                        textFieldDisplay.setText("");
                    }

                    textFieldDisplay.setText(textFieldDisplay.getText() + comando);
                }
        }



    }
     // usado para testar se é um operador 
    private boolean isOperador(char operador){
        return  operador == '+' || operador == '-' || operador == '*' || operador == '/';
    }

    private double verficarExpressao(String expressao){
            try{
                //remover os espaços em branco e caracteres invalidos.
                expressao = expressao.replaceAll("//s+", "");
                if(expressao.isEmpty()){
                    return 0;
                }
                //dividindo a expressao em partes separadas pelos operadores.
                Pattern pattern = Pattern.compile("[+\\-*/]");
                Matcher matcher = pattern.matcher(expressao);
                String [] partesExpressao = pattern.split(expressao);
                // converter as partes em numeros e operadores
                double resultado = Double.parseDouble(partesExpressao[0]);
                int i = 1;

                //realiza as operaçoes sequencialmente
                while (matcher.find()) {
                    String operador = matcher.group();
                    double valor = Double.parseDouble(partesExpressao[i++]);

                    switch (operador) {
                        case "+":
                        resultado += valor;
                            break;
                        case "-":
                        resultado -= valor;
                            break;
                        case "*":
                        resultado *= valor;
                            break;
                        case "/":
                        resultado /= valor;
                            break;
                      
                    }
                    
                }

                return resultado;

            }catch(NumberFormatException | ArithmeticException e){
                return 0;

            }
        }
   
}