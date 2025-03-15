
import com.sun.tools.javac.Main;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;

public class UI_Home {
    private JFrame Mainframe;
    private JFrame inputFrame;
    private JFrame inputFrame2;
    private JFrame inputFrame3;
    private JPanel panel;
    private JLabel label;
    private JTextField textfield;

    public UI_Home() {
        initializeHome();
        showHomeFrame();
        intitializeItemInput_add();
        intitializeItemInput_modify();
        intitializeItemInput_delete();
        //showInputFrame();
        //hideInputFrame();
    }
    //Global Variables for this Class.
    String name = "Placeholder Name";
    String type = "Placeholder Type";
    String colourgroup = "Placeholder Colourgroup";
    String hexcode = "#AABBCC";
    String date_bought = "01-01-2000";

    private void initializeHome() {
        Mainframe = new JFrame();
        Mainframe.setTitle("Wardrobe Management System: Home");
        Mainframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //closes window when X is pressed.
        Mainframe.setSize(192 * 8, 108 * 8);// *10 for 1920 x 1080 pixels
        Mainframe.setResizable(true); //Turn to false if window size needs to be fixed.
        Mainframe.setLocationRelativeTo(null);

        //This code is to create and add the buttons to the frame.
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT,16,16)); //FLowLayout changes which alignment side the button is on.
        buttonPanel.setBackground(Color.DARK_GRAY);
        buttonPanel.setPreferredSize(new Dimension(64,64));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(5,10,10,10));

        //Text that appears on the top portion of the Frame.
        label = new JLabel("");//"Your Wardrobe." Kept empty as it is not working as intended.
        label.setForeground(Color.WHITE);
        label.setFont(new Font("Sans-serif",Font.BOLD,36));
        label.setAlignmentX(Component.LEFT_ALIGNMENT);//Does not align it to left for some reason.
        buttonPanel.add(label);


        String itemDescriptionText = " \n"+ type +"\n"+ colourgroup+"\n"+hexcode+"\n"+date_bought;
        //Below is the code for the Add Button
        Button buttonAdd = new Button("Add Item"); //creates button
        buttonAdd.setFont(new Font("Arial",Font.PLAIN,20));
        buttonAdd.setBackground(Color.GREEN); //Too Bright
        buttonAdd.setForeground(Color.WHITE);
        buttonPanel.add(buttonAdd);
        buttonAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Add a call to the Add Item Function
                //System.out.println("Add Item Button has been clicked. Waiting 120 seconds for input, then executing command to add values in database.");
                showInputFrame();
//                try {
//                    TimeUnit.SECONDS.sleep(120);
//                } catch (InterruptedException ex) {
//                    throw new RuntimeException(ex);
//                }
//                System.out.println("Wait complete. executing command to modify values in database.");
                //CRUDE.addValues(name,type,colourgroup,hexcode);
            }
        });


        //Below is the code for the Modify Button
        Button buttonModify = new Button("Modify Item"); //creates button
        buttonModify.setFont(new Font("Arial",Font.PLAIN,20));
        buttonModify.setBackground(Color.CYAN); //Too Bright
        buttonModify.setForeground(Color.WHITE);
        buttonPanel.add(buttonModify);
        buttonModify.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Add a call to the Modify Item Function
                //System.out.println("Modify Item Button has been clicked. Waiting 120 seconds for input, then executing command to modify values in database.");
                showInputFrame2();
//                //The program needs to wait for the user to enter values.
//                try {
//                    TimeUnit.SECONDS.sleep(120);
//                } catch (InterruptedException ex) {
//                    throw new RuntimeException(ex);
//                }
//                System.out.println("Wait complete. executing command to modify values in database.");
                //CRUDE.modifyValues(name,type,colourgroup,hexcode);
            }
        });

        //Below is the code for the Delete Button
        Button buttonDelete = new Button("Delete Item"); //creates button
        buttonDelete.setFont(new Font("Arial",Font.PLAIN,20));
        buttonDelete.setBackground(Color.RED); //Too Bright
        buttonDelete.setForeground(Color.WHITE);
        buttonPanel.add(buttonDelete);
        buttonDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Add a call to the Delete Item Function
                //System.out.println("Delete Item Button has been clicked. Waiting 120 seconds for input, then executing command to delete values in database.");
                showInputFrame3();
//                try {
//                    TimeUnit.SECONDS.sleep(120);
//                } catch (InterruptedException ex) {
//                    throw new RuntimeException(ex);
//                }
//                System.out.println("Wait complete. executing command to modify values in database.");
                //CRUDE.deleteItem(name);
            }
        });

        Mainframe.add(buttonPanel, BorderLayout.NORTH);

        //This panel is on the leftmost side and displays the item along with its description.
        JPanel itemInfoPanel = new JPanel();
        itemInfoPanel.setBackground(Color.CYAN);
        itemInfoPanel.setPreferredSize(new Dimension(192*3,108));
        itemInfoPanel.setBorder(BorderFactory.createEmptyBorder(30,10,10,10));

        JLabel itemName = new JLabel(name); //This label shows the Name of the Item.
        itemName.setForeground(Color.WHITE);
        itemName.setFont(new Font("Sans-serif",Font.BOLD,36));
        JTextArea itemDescription = new JTextArea(itemDescriptionText);
        itemDescription.setFont(new Font("Sans-serif",Font.BOLD,26));
        itemDescription.setForeground(Color.BLACK);
        itemDescription.setBackground(Color.CYAN);
        itemInfoPanel.add(itemName);
        itemInfoPanel.add(itemDescription, BorderLayout.CENTER);
        Mainframe.add(itemInfoPanel, BorderLayout.WEST);





        //This panel is on the rightmost side and displays all items. (Name Only)
        JPanel allItemsDisplay = new JPanel(); //This should display the database of all items.
        allItemsDisplay.setBackground(Color.DARK_GRAY);
        allItemsDisplay.setPreferredSize(new Dimension(192*2,108));
        allItemsDisplay.setBorder(BorderFactory.createEmptyBorder(30,10,10,10));

        JTextArea allItems;
        allItems = new JTextArea("Your Wardrobe\n\n\n"+CRUDE.displayItemNames());//This needs to refresh once changes are made
        allItems.setFont(new Font("Sans-serif",Font.BOLD,20));
        allItems.setForeground(Color.WHITE);
        allItems.setBackground(Color.DARK_GRAY);
        allItemsDisplay.add(allItems, BorderLayout.CENTER);


        Mainframe.add(allItemsDisplay, BorderLayout.EAST);

        //This panel displays the selected item's complementary colour, and finds clothes that are the same colour.
        JPanel ComplementaryDisplay = new JPanel();
        ComplementaryDisplay.setBackground(Color.pink);
        ComplementaryDisplay.setPreferredSize(new Dimension(192*3,108));
        ComplementaryDisplay.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        JTextArea additionalInfo = new JTextArea("\nPlaceholder additional info");
        additionalInfo.setFont(new Font("Sans-serif",Font.BOLD,20));
        additionalInfo.setForeground(Color.BLACK);
        additionalInfo.setBackground(Color.PINK);
        ComplementaryDisplay.add(additionalInfo, BorderLayout.CENTER);
        Mainframe.add(ComplementaryDisplay, BorderLayout.CENTER);

    }


    private void intitializeItemInput_add(){
        inputFrame = new JFrame();
        inputFrame.setTitle("Wardrobe Management System: Home");
        inputFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //closes window when X is pressed.
        inputFrame.setSize(192 * 6, 108 * 6);// *10 for 1920 x 1080 pixels
        inputFrame.setResizable(true); //Turn to false if window size needs to be fixed.
        inputFrame.setLocationRelativeTo(null);

        JPanel input = new JPanel();
        input.setBorder(BorderFactory.createEmptyBorder(150,10,10,10));

        //TextBox for setting name
        JTextField nameText = new JTextField(10);//10 specifies width of text field
        nameText.setFont(new Font("Arial",Font.BOLD,26));//The font size changes height of the text field
        nameText.setForeground(Color.BLACK);
        nameText.setBackground(Color.LIGHT_GRAY);
        nameText.setToolTipText("Enter the name of the clothing item.");
        nameText.setMargin(new Insets(5,10,5,10));
        final boolean[] nameTextClicked = {false};
        nameText.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                name = nameText.getText();
                nameText.setText("Name has been registered!");
                nameTextClicked[0] = true;
            }
        });
        input.add(nameText);

        //TextBox for setting clothing type
        JTextField typeText = new JTextField(10);//10 specifies width of text field
        typeText.setFont(new Font("Arial",Font.BOLD,26));//The font size changes height of the text field
        typeText.setForeground(Color.BLACK);
        typeText.setBackground(Color.LIGHT_GRAY);
        typeText.setToolTipText("Enter the clothing type of the clothing item.");
        typeText.setMargin(new Insets(5,10,5,10));
        final boolean[] typeTextClicked = {false};
        typeText.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                type = typeText.getText();
                typeText.setText("Clothing type has been registered!");
                typeTextClicked[0] = true;
            }
        });
        input.add(typeText);


        //TextBox for setting colourgroup
        JTextField colourGroupText = new JTextField(10);//10 specifies width of text field
        colourGroupText.setFont(new Font("Arial",Font.BOLD,26));//The font size changes height of the text field
        colourGroupText.setForeground(Color.BLACK);
        colourGroupText.setBackground(Color.LIGHT_GRAY);
        colourGroupText.setToolTipText("Enter the colour of the clothing item.");
        colourGroupText.setMargin(new Insets(5,10,5,10));
        final boolean[] colourGroupTextClicked = {false};
        colourGroupText.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                colourgroup = colourGroupText.getText();
                colourGroupText.setText("Colour has been registered!");
                colourGroupTextClicked[0] = true;
            }
        });
        input.add(colourGroupText);

        //TextBox for setting hexcode
        JTextField hexcodeText = new JTextField(10);//10 specifies width of text field
        hexcodeText.setFont(new Font("Arial",Font.BOLD,26));//The font size changes height of the text field
        hexcodeText.setForeground(Color.BLACK);
        hexcodeText.setBackground(Color.LIGHT_GRAY);
        hexcodeText.setToolTipText("Enter the hexcode of the clothing item (Include the #)");
        hexcodeText.setMargin(new Insets(5,10,5,10));
        final boolean[] hexcodeTextClicked = {false};
        hexcodeText.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hexcode = hexcodeText.getText();
                hexcodeText.setText("hexcode has been registered!");
                hexcodeTextClicked[0] = true;
            }
        });
        input.add(hexcodeText);

        JPanel infotextPanel = new JPanel();
        JTextArea infotext = new JTextArea("\nPress Enter to Submit.");
        infotext.setFont(new Font("Arial",Font.BOLD,26));//The font size changes height of the text field
        infotext.setForeground(Color.BLACK);
        infotext.setBackground(Color.WHITE);
        infotextPanel.add(infotext);
        infotextPanel.setBorder(BorderFactory.createEmptyBorder(10,10,150,10));

        inputFrame.add(input, BorderLayout.CENTER);
        inputFrame.add(infotextPanel, BorderLayout.SOUTH);

        if(nameTextClicked[0] == true && typeTextClicked[0] == true && colourGroupTextClicked[0] == true && hexcodeTextClicked[0] == true){
            System.out.println("Valid input detected. adding values to database.");
            CRUDE.addValues(name, type, colourgroup, hexcode);
            HideInputFrame();
        }

    }
    private void intitializeItemInput_modify(){
        inputFrame2 = new JFrame();
        inputFrame2.setTitle("Wardrobe Management System: Home");
        inputFrame2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //closes window when X is pressed.
        inputFrame2.setSize(192 * 6, 108 * 6);// *10 for 1920 x 1080 pixels
        inputFrame2.setResizable(true); //Turn to false if window size needs to be fixed.
        inputFrame2.setLocationRelativeTo(null);

        JPanel input = new JPanel();
        input.setBorder(BorderFactory.createEmptyBorder(150,10,10,10));

        
        //TextBox for setting name
        JTextField nameText = new JTextField(10);//10 specifies width of text field
        nameText.setFont(new Font("Arial",Font.BOLD,26));//The font size changes height of the text field
        nameText.setForeground(Color.BLACK);
        nameText.setBackground(Color.LIGHT_GRAY);
        nameText.setToolTipText("Enter the name of the clothing item.");
        nameText.setMargin(new Insets(5,10,5,10));
        final boolean[] nameTextClicked = {false};
        nameText.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                name = nameText.getText();
                nameText.setText("Name has been registered!");
                nameTextClicked[0] = true;
            }
        });
        input.add(nameText);

        //TextBox for setting clothing type
        JTextField typeText = new JTextField(10);//10 specifies width of text field
        typeText.setFont(new Font("Arial",Font.BOLD,26));//The font size changes height of the text field
        typeText.setForeground(Color.BLACK);
        typeText.setBackground(Color.LIGHT_GRAY);
        typeText.setToolTipText("Enter the clothing type of the clothing item.");
        typeText.setMargin(new Insets(5,10,5,10));
        final boolean[] typeTextClicked = {false};
        typeText.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                type = typeText.getText();
                typeText.setText("Clothing type has been registered!");
                typeTextClicked[0] = true;
            }
        });
        input.add(typeText);


        //TextBox for setting colourgroup
        JTextField colourGroupText = new JTextField(10);//10 specifies width of text field
        colourGroupText.setFont(new Font("Arial",Font.BOLD,26));//The font size changes height of the text field
        colourGroupText.setForeground(Color.BLACK);
        colourGroupText.setBackground(Color.LIGHT_GRAY);
        colourGroupText.setToolTipText("Enter the colour of the clothing item.");
        colourGroupText.setMargin(new Insets(5,10,5,10));
        final boolean[] colourgroupTextClicked = {false};
        colourGroupText.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                colourgroup = colourGroupText.getText();
                colourGroupText.setText("Colour has been registered!");
                colourgroupTextClicked[0] = true;
            }
        });
        input.add(colourGroupText);

        //TextBox for setting hexcode
        JTextField hexcodeText = new JTextField(10);//10 specifies width of text field
        hexcodeText.setFont(new Font("Arial",Font.BOLD,26));//The font size changes height of the text field
        hexcodeText.setForeground(Color.BLACK);
        hexcodeText.setBackground(Color.LIGHT_GRAY);
        hexcodeText.setToolTipText("Enter the hexcode of the clothing item (Include the #)");
        hexcodeText.setMargin(new Insets(5,10,5,10));
        final boolean[] hexcodeTextClicked = {false};
        hexcodeText.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hexcode = hexcodeText.getText();
                hexcodeText.setText("hexcode has been registered!");
                hexcodeTextClicked[0] = true;
            }
        });
        input.add(hexcodeText);

        JPanel infotextPanel = new JPanel();
        JTextArea infotext = new JTextArea("\nPress Enter to Submit.");
        infotext.setFont(new Font("Arial",Font.BOLD,26));//The font size changes height of the text field
        infotext.setForeground(Color.BLACK);
        infotext.setBackground(Color.WHITE);
        infotextPanel.add(infotext);
        infotextPanel.setBorder(BorderFactory.createEmptyBorder(10,10,150,10));

        inputFrame2.add(input, BorderLayout.CENTER);
        inputFrame2.add(infotextPanel, BorderLayout.SOUTH);


        if(nameTextClicked[0] == true && typeTextClicked[0] == true && colourgroupTextClicked[0] == true && hexcodeTextClicked[0] == true){
            System.out.println("Valid input detected. modifying values in database.");
            CRUDE.modifyValues(name, type, colourgroup, hexcode);
            HideInputFrame2();
        }
    }
    private void intitializeItemInput_delete(){
        inputFrame3 = new JFrame();
        inputFrame3.setTitle("Wardrobe Management System: Home");
        inputFrame3.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //closes window when X is pressed.
        inputFrame3.setSize(192 * 6, 108 * 6);// *10 for 1920 x 1080 pixels
        inputFrame3.setResizable(true); //Turn to false if window size needs to be fixed.
        inputFrame3.setLocationRelativeTo(null);

        JPanel input = new JPanel();
        input.setBorder(BorderFactory.createEmptyBorder(150,10,10,10));


        //TextBox for setting name
        JTextField nameText = new JTextField(10);//10 specifies width of text field
        nameText.setFont(new Font("Arial",Font.BOLD,26));//The font size changes height of the text field
        nameText.setForeground(Color.BLACK);
        nameText.setBackground(Color.LIGHT_GRAY);
        nameText.setToolTipText("Enter the name of the clothing item.");
        nameText.setMargin(new Insets(5,10,5,10));
        final boolean[] nameTextClicked = {false};
        nameText.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                name = nameText.getText();
                nameText.setText("Name has been registered!");
                nameTextClicked[0] = true;
            }
        });
        input.add(nameText);

        JPanel infotextPanel = new JPanel();
        JTextArea infotext = new JTextArea("\nPress Enter to Submit.");
        infotext.setFont(new Font("Arial",Font.BOLD,26));//The font size changes height of the text field
        infotext.setForeground(Color.BLACK);
        infotext.setBackground(Color.WHITE);
        infotextPanel.add(infotext);
        infotextPanel.setBorder(BorderFactory.createEmptyBorder(10,10,150,10));

        inputFrame3.add(input, BorderLayout.CENTER);
        inputFrame3.add(infotextPanel, BorderLayout.SOUTH);

        if(nameTextClicked[0] == true){
            System.out.println("Valid input detected. deleting values in database.");
            CRUDE.deleteItem(name);
            HideInputFrame3();
        }
    }

    private void showHomeFrame(){
        Mainframe.setVisible(true);
    }
    private void showInputFrame(){
        inputFrame.setVisible(true);
    }
    private void HideInputFrame(){
        inputFrame.setVisible(false);
    }
    private void showInputFrame2(){
        inputFrame2.setVisible(true);
    }
    private void HideInputFrame2(){
        inputFrame2.setVisible(false);
    }
    private void showInputFrame3(){
        inputFrame3.setVisible(true);
    }
    private void HideInputFrame3(){
        inputFrame3.setVisible(false);
    }

}
