
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UI_Home {
    private JFrame Mainframe;
    private JFrame inputFrame;//Add Item
    private JFrame inputFrame2;// Modify Item
    private JFrame inputFrame3;// Delete Item
    private JFrame inputFrame4;// Select Item
    private JFrame globalSearchFrame;
    private JFrame typeSearchFrame;
    private JFrame hexcodeSearchFrame;
    private JFrame dateSearchFrame;
    private JLabel label;
    private JTextArea allItems;

    public UI_Home() {
        initializeHome();
        showHomeFrame();
        intitializeItemInput_add();
        intitializeItemInput_modify();
        intitializeItemInput_delete();
    }
    //Global Variables for this Class.
    String name = "Placeholder Name";
    String type = "Placeholder Type";
    String colourgroup = "Placeholder Colourgroup";
    String hexcode = "#AABBCC";
    String date_bought = "2000-12-20";
    String itemDescriptionText = " \n"+ type +"\n"+ colourgroup+"\n"+hexcode+"\n"+date_bought;
    String itemNames = "Placeholder Item Names";
    JLabel itemList = new JLabel(itemNames);

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
                showInputFrame();
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
                showInputFrame2();
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
                showInputFrame3();
            }
        });

        Mainframe.add(buttonPanel, BorderLayout.NORTH);

        //This panel is on the leftmost side and displays the item along with its description.
        JPanel itemInfoPanel = new JPanel();
//        JPanel itemInfoPanel = new JPanel() { //The image is not correctly resized, leading to it not displaying properly.
//            @Override
//            protected void paintComponent(Graphics g) {
//                super.paintComponent(g);
//                Image image = Toolkit.getDefaultToolkit().createImage("\"C:\\Users\\athar\\IdeaProjects\\Wardrobe_Management_System\\test_Project\\UI elements\\ItemCard_Background.png\"");
//                g.drawImage(image, 0, 0, null);
//            }
//        };
        itemInfoPanel.setBackground(Color.WHITE);


        itemInfoPanel.setPreferredSize(new Dimension(192*3,108));
        itemInfoPanel.setBorder(BorderFactory.createEmptyBorder(30,10,10,10));
        //String itemDescriptionText = " \n"+ type +"\n"+ colourgroup+"\n"+hexcode+"\n"+date_bought; //DO NOT UNCOMMENT. This is only kept for reference.
        JLabel itemName = new JLabel(name); //This label shows the Name of the Item.
        itemName.setBorder(BorderFactory.createEmptyBorder(30,150,10,150));
        itemName.setForeground(Color.BLACK);
        itemName.setFont(new Font("Sans-serif",Font.BOLD,36));

        JTextArea additionalInfo = new JTextArea("\n");//This provides a list of all complementary colours.
        additionalInfo.setFont(new Font("Sans-serif",Font.BOLD,20));
        additionalInfo.setForeground(Color.BLACK);
        additionalInfo.setBackground(Color.PINK);
        additionalInfo.setBorder(BorderFactory.createEmptyBorder(20,200,20,200));



        JTextArea itemDescription = new JTextArea(itemDescriptionText);//This is additional Item Description. Type, Hexcode etc.
        itemDescription.setFont(new Font("Sans-serif",Font.BOLD,26));
        itemDescription.setBorder(BorderFactory.createEmptyBorder(30,150,30,150));
        itemDescription.setForeground(Color.BLACK);
        itemDescription.setBackground(Color.WHITE);
        itemInfoPanel.add(itemName,BorderLayout.CENTER);
        itemInfoPanel.add(itemDescription, BorderLayout.CENTER);


        Mainframe.add(itemInfoPanel, BorderLayout.WEST);





        //This panel is on the rightmost side and displays all items. (Name Only)
        JPanel allItemsDisplay = new JPanel(); //This should display the database of all items.
        allItemsDisplay.setBackground(Color.DARK_GRAY);
        allItemsDisplay.setPreferredSize(new Dimension(192*2,108));
        allItemsDisplay.setBorder(BorderFactory.createEmptyBorder(30,50,10,50));

        JLabel yourWardrobe = new JLabel("Your Wardrobe:"); //This label shows the Name of the Item.
        yourWardrobe.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        yourWardrobe.setForeground(Color.WHITE);
        yourWardrobe.setFont(new Font("Sans-serif",Font.BOLD,28));
        allItemsDisplay.add(yourWardrobe, BorderLayout.WEST);
        Button buttonFind = new Button("Select Item by Name"); //creates button
        buttonFind.setFont(new Font("Arial",Font.PLAIN,20));
        buttonFind.setBackground(Color.WHITE); //Too Bright
        buttonFind.setForeground(Color.BLACK);
        allItemsDisplay.add(buttonFind);
        buttonFind.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Add a call to Select item to provide a description for, using its name.
                /*
                Use a JFrame to take name as input. This name later feeds into a function in the CRUDE class, which will
                make a statement that searches for all items with the entered name.
                 */
                showInputFrame4();
                //System.out.println("This function does not exist yet.");
            }
        });

        Button globalSearch = new Button("Search by Categories"); //creates button
        globalSearch.setFont(new Font("Arial",Font.PLAIN,18));
        globalSearch.setBackground(Color.WHITE); //Too Bright
        globalSearch.setForeground(Color.BLACK);
        allItemsDisplay.add(globalSearch);
        globalSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Use a similar function process to Find Complement button.
                //YYYY-MM-DD, e.g. 2020-12-20
                showGlobalSearchFrame();
                //itemList.setText(itemNames);//Troubleshoot and check if this returns an empty value or changes.
            }
        });

        Button buttonComplement = new Button("Find Complement!"); //creates button
        buttonComplement.setFont(new Font("Arial",Font.PLAIN,18));
        buttonComplement.setBackground(Color.WHITE); //Too Bright
        buttonComplement.setForeground(Color.BLACK);
        allItemsDisplay.add(buttonComplement);
        buttonComplement.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Add a call to Select item to provide a description for, using its name.
                /*
                Use a funtion in the CRUDE class that can find the selected clothing item's colour.
                This Colour later feeds into a function in the CRUDE class, which will
                make a statement that searches for all items with the same colour as the selected item.
                 */
                CRUDE.setColour(colourgroup);
                CRUDE.findColour();
                additionalInfo.setText(CRUDE.getAllColour());
            }
        });

        allItems = new JTextArea(""+CRUDE.displayItemNames());
        allItems.setFont(new Font("Sans-serif",Font.BOLD,24));
        allItems.setForeground(Color.WHITE);
        allItems.setBackground(Color.DARK_GRAY);
        allItems.setBorder(BorderFactory.createEmptyBorder(20,30,10,30));
        allItems.update(allItems.getGraphics());
        allItemsDisplay.add(allItems, BorderLayout.CENTER);
        Mainframe.add(allItemsDisplay, BorderLayout.EAST);

        //This panel displays the selected item's complementary colour, and finds clothes that are the same colour.
        JPanel ComplementaryDisplay = new JPanel();
        ComplementaryDisplay.setBackground(Color.pink);
        ComplementaryDisplay.setPreferredSize(new Dimension(192*3,108));
        ComplementaryDisplay.setBorder(BorderFactory.createEmptyBorder(20,50,20,50));


//        JTextArea additionalInfo = new JTextArea("\n");
//        additionalInfo.setFont(new Font("Sans-serif",Font.BOLD,20));
//        additionalInfo.setForeground(Color.BLACK);
//        additionalInfo.setBackground(Color.PINK);
//        additionalInfo.setBorder(BorderFactory.createEmptyBorder(20,150,20,150));

//        Button buttonComplement = new Button("Find Complement!"); //creates button
//        buttonComplement.setFont(new Font("Arial",Font.PLAIN,24));
//        buttonComplement.setBackground(Color.WHITE); //Too Bright
//        buttonComplement.setForeground(Color.BLACK);
//        ComplementaryDisplay.add(buttonComplement);
//        buttonComplement.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                //Add a call to Select item to provide a description for, using its name.
//                /*
//                Use a funtion in the CRUDE class that can find the selected clothing item's colour.
//                This Colour later feeds into a function in the CRUDE class, which will
//                make a statement that searches for all items with the same colour as the selected item.
//                 */
//                CRUDE.setColour(colourgroup);
//                CRUDE.findColour();
//                additionalInfo.setText(CRUDE.getAllColour());
//            }
//        });
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
                nameText.setText("Registered!");
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
                typeText.setText("Registered!");
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
                colourGroupText.setText("Registered!");
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
                hexcodeText.setText("Registered!");
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
        infotextPanel.setBorder(BorderFactory.createEmptyBorder(50,10,50,10));

        inputFrame.add(input, BorderLayout.CENTER);
        inputFrame.add(infotextPanel, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10,10,20,10));
        Button buttonAdd = new Button("Add Item!"); //creates button
        buttonAdd.setFont(new Font("Arial",Font.PLAIN,20));
        buttonAdd.setBackground(Color.GREEN); //Too Bright
        buttonAdd.setForeground(Color.WHITE);

        buttonPanel.add(buttonAdd);
        buttonAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //if statement inside this block.
                if(nameTextClicked[0] == true && typeTextClicked[0] == true && colourGroupTextClicked[0] == true && hexcodeTextClicked[0] == true){
                    System.out.println("Valid input detected. adding values to database.");
                    CRUDE.addValues(name, type, colourgroup, hexcode);
                    HideInputFrame();
                    hideHomeFrame();
                    showHomeFrame();
                    System.out.println("New Values are:");
                    CRUDE.showAllItems();
                }
            }
        });

        inputFrame.add(buttonPanel, BorderLayout.SOUTH);

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
                nameText.setText("Registered!");
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
                typeText.setText("Registered!");
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
                colourGroupText.setText("Registered!");
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
                hexcodeText.setText("Registered!");
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
        infotextPanel.setBorder(BorderFactory.createEmptyBorder(50,10,50,10));

        inputFrame2.add(input, BorderLayout.CENTER);
        inputFrame2.add(infotextPanel, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10,10,20,10));
        Button buttonModify = new Button("Modify Item!"); //creates button
        buttonModify.setFont(new Font("Arial",Font.PLAIN,20));
        buttonModify.setBackground(Color.CYAN); //Too Bright
        buttonModify.setForeground(Color.WHITE);

        buttonPanel.add(buttonModify);
        buttonModify.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //if statement inside this block.
                if(nameTextClicked[0] == true && typeTextClicked[0] == true && colourgroupTextClicked[0] == true && hexcodeTextClicked[0] == true){
                    System.out.println("Valid input detected. modifying values in database.");
                    CRUDE.modifyValues(name, type, colourgroup, hexcode);
                    hideHomeFrame();
                    showHomeFrame();
                    HideInputFrame2();
                    System.out.println("New Values are:");
                    CRUDE.showAllItems();
                    //allItems.update(allItems.getGraphics());
                }
            }
        });

        inputFrame2.add(buttonPanel, BorderLayout.SOUTH);

    }
    private void intitializeItemInput_select(){
        inputFrame4 = new JFrame();
        inputFrame4.setTitle("Wardrobe Management System: Select Item");
        inputFrame4.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //closes window when X is pressed.
        inputFrame4.setSize(192 * 6, 108 * 6);// *10 for 1920 x 1080 pixels
        inputFrame4.setResizable(true); //Turn to false if window size needs to be fixed.
        inputFrame4.setLocationRelativeTo(null);

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
                nameText.setText("Registered!");
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
        infotextPanel.setBorder(BorderFactory.createEmptyBorder(50,10,50,10));

        inputFrame4.add(input, BorderLayout.CENTER);
        inputFrame4.add(infotextPanel, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10,10,20,10));
        Button buttonSelect = new Button("Select Item!"); //creates button
        buttonSelect.setFont(new Font("Arial",Font.PLAIN,20));
        buttonSelect.setBackground(Color.GREEN); //Too Bright
        buttonSelect.setForeground(Color.WHITE);

        buttonPanel.add(buttonSelect);
        buttonSelect.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //if statement inside this block.
                if(nameTextClicked[0] == true){
                    System.out.println("Valid input detected. Selecting values in database.");
                    //itemDescriptionText = String.valueOf(CRUDE.selectItem(name)); //returns all values pertaining to item.
                    String[] allValues =CRUDE.selectItem(name);//0 to 4.
                    name = allValues[0];
                    type = allValues[1];
                    colourgroup = allValues[2];
                    hexcode = allValues[3];
                    date_bought = allValues[4];

                    itemDescriptionText = "\n"+ type +"\n"+ colourgroup+"\n"+hexcode+"\n"+date_bought;
                    hideHomeFrame();
                    showHomeFrame();
                    HideInputFrame4();
                    System.out.println("New Values are:");
                    CRUDE.showAllItems();
                }
            }
        });

        inputFrame4.add(buttonPanel, BorderLayout.SOUTH);

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
                nameText.setText("Registered!");
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
        infotextPanel.setBorder(BorderFactory.createEmptyBorder(50,10,50,10));

        inputFrame3.add(input, BorderLayout.CENTER);
        inputFrame3.add(infotextPanel, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10,10,20,10));
        Button buttonDelete = new Button("Delete Item!"); //creates button
        buttonDelete.setFont(new Font("Arial",Font.PLAIN,20));
        buttonDelete.setBackground(Color.RED); //Too Bright
        buttonDelete.setForeground(Color.WHITE);

        buttonPanel.add(buttonDelete);
        buttonDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //if statement inside this block.
                if(nameTextClicked[0] == true){
                    System.out.println("Valid input detected. deleting values in database.");
                    CRUDE.deleteItem(name);
                    hideHomeFrame();
                    showHomeFrame();
                    HideInputFrame3();
                    System.out.println("New Values are:");
                    CRUDE.showAllItems();
                }
            }
        });

        inputFrame3.add(buttonPanel, BorderLayout.SOUTH);

    }


    private void intitializeGlobalSearch(){
        globalSearchFrame = new JFrame();
        globalSearchFrame.setTitle("Wardrobe Management System: Global Search");
        globalSearchFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //closes window when X is pressed.
        globalSearchFrame.setSize(192 * 6, 108 * 6);// *10 for 1920 x 1080 pixels
        globalSearchFrame.setResizable(true); //Turn to false if window size needs to be fixed.
        globalSearchFrame.setLocationRelativeTo(null);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(150,10,10,10));

        Button buttonType = new Button("Item Type"); //creates button
        buttonType.setFont(new Font("Arial",Font.PLAIN,20));
        buttonType.setBackground(Color.DARK_GRAY); //Too Bright
        buttonType.setForeground(Color.WHITE);
        buttonPanel.add(buttonType);
        buttonType.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Searching items by Item Type.");
                showTypeSearchFrame();
                hideGlobalSearchFrame();
            }
        });



        Button buttonhexcode = new Button("Item Hexcode"); //creates button
        buttonhexcode.setFont(new Font("Arial",Font.PLAIN,20));
        buttonhexcode.setBackground(Color.DARK_GRAY); //Too Bright
        buttonhexcode.setForeground(Color.WHITE);
        buttonPanel.add(buttonhexcode);
        buttonhexcode.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Searching items by Item hexcode.");
                showHexcodeSearchFrame();
                hideGlobalSearchFrame();
            }
        });

        Button buttonDate = new Button("Date Bought"); //creates button
        buttonDate.setFont(new Font("Arial",Font.PLAIN,20));
        buttonDate.setBackground(Color.DARK_GRAY); //Too Bright
        buttonDate.setForeground(Color.WHITE);
        buttonPanel.add(buttonDate);

        buttonDate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Searching items by Date.");
                showDateSearchFrame();
                hideGlobalSearchFrame();
            }
        });



        globalSearchFrame.add(buttonPanel, BorderLayout.CENTER);

    }

    private void intitializeTypeSearch(){
        typeSearchFrame = new JFrame();
        typeSearchFrame.setTitle("Wardrobe Management System: Type Search");
        typeSearchFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //closes window when X is pressed.
        typeSearchFrame.setSize(192 * 6, 108 * 6);// *10 for 1920 x 1080 pixels
        typeSearchFrame.setResizable(true); //Turn to false if window size needs to be fixed.
        typeSearchFrame.setLocationRelativeTo(null);

        JPanel input = new JPanel();
        input.setBorder(BorderFactory.createEmptyBorder(150,10,10,10));


        //TextBox for setting name
        JTextField typeText = new JTextField(10);//10 specifies width of text field
        typeText.setFont(new Font("Arial",Font.BOLD,26));//The font size changes height of the text field
        typeText.setForeground(Color.BLACK);
        typeText.setBackground(Color.LIGHT_GRAY);
        typeText.setToolTipText("Enter the Type of the clothing item.");
        typeText.setMargin(new Insets(5,10,5,10));
        final boolean[] typeTextClicked = {false};
        typeText.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                type = typeText.getText();
                typeText.setText("Registered!");
                typeTextClicked[0] = true;
            }
        });
        input.add(typeText);

        JPanel infotextPanel = new JPanel();
        JTextArea infotext = new JTextArea("\nPress Enter to Submit.");
        infotext.setFont(new Font("Arial",Font.BOLD,26));//The font size changes height of the text field
        infotext.setForeground(Color.BLACK);
        infotext.setBackground(Color.WHITE);
        infotextPanel.add(infotext);
        infotextPanel.setBorder(BorderFactory.createEmptyBorder(50,10,50,10));

        typeSearchFrame.add(input, BorderLayout.CENTER);
        typeSearchFrame.add(infotextPanel, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10,10,20,10));
        Button buttonDelete = new Button("Search!"); //creates button
        buttonDelete.setFont(new Font("Arial",Font.PLAIN,20));
        buttonDelete.setBackground(Color.GREEN); //Too Bright
        buttonDelete.setForeground(Color.WHITE);

        buttonPanel.add(buttonDelete);
        buttonDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //if statement inside this block.
                if(typeTextClicked[0] == true){
                    System.out.println("Valid input detected. searching for values in database.");
                    infotext.setText(CRUDE.typeSearch(type));
                    System.out.println("New Values are:");
                    CRUDE.showAllItems();
                }
            }
        });

        typeSearchFrame.add(buttonPanel, BorderLayout.SOUTH);

    }

    private void intitializeHexcodeSearch(){
        hexcodeSearchFrame = new JFrame();
        hexcodeSearchFrame.setTitle("Wardrobe Management System: Hexcode Search");
        hexcodeSearchFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //closes window when X is pressed.
        hexcodeSearchFrame.setSize(192 * 6, 108 * 6);// *10 for 1920 x 1080 pixels
        hexcodeSearchFrame.setResizable(true); //Turn to false if window size needs to be fixed.
        hexcodeSearchFrame.setLocationRelativeTo(null);

        JPanel input = new JPanel();
        input.setBorder(BorderFactory.createEmptyBorder(150,10,10,10));


        //TextBox for setting name
        JTextField nameText = new JTextField(10);//10 specifies width of text field
        nameText.setFont(new Font("Arial",Font.BOLD,26));//The font size changes height of the text field
        nameText.setForeground(Color.BLACK);
        nameText.setBackground(Color.LIGHT_GRAY);
        nameText.setToolTipText("Enter the hexcode of the clothing item.");
        nameText.setMargin(new Insets(5,10,5,10));
        final boolean[] hexcodeTextClicked = {false};
        nameText.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hexcode = nameText.getText();
                nameText.setText("Registered!");
                hexcodeTextClicked[0] = true;
            }
        });
        input.add(nameText);

        JPanel infotextPanel = new JPanel();
        JTextArea infotext = new JTextArea("\nPress Enter to Submit.");
        infotext.setFont(new Font("Arial",Font.BOLD,26));//The font size changes height of the text field
        infotext.setForeground(Color.BLACK);
        infotext.setBackground(Color.WHITE);
        infotextPanel.add(infotext);
        infotextPanel.setBorder(BorderFactory.createEmptyBorder(50,10,50,10));

        hexcodeSearchFrame.add(input, BorderLayout.CENTER);
        hexcodeSearchFrame.add(infotextPanel, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10,10,20,10));
        Button buttonDelete = new Button("Search!"); //creates button
        buttonDelete.setFont(new Font("Arial",Font.PLAIN,20));
        buttonDelete.setBackground(Color.GREEN); //Too Bright
        buttonDelete.setForeground(Color.WHITE);

        buttonPanel.add(buttonDelete);
        buttonDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //if statement inside this block.
                if(hexcodeTextClicked[0] == true){
                    System.out.println("Valid input detected. deleting values in database.");
                    infotext.setText(CRUDE.hexcodeSearch(hexcode));
                    System.out.println("New Values are:");
                    CRUDE.showAllItems();
                }
            }
        });

        hexcodeSearchFrame.add(buttonPanel, BorderLayout.SOUTH);

    }

    private void intitializeDateSearch(){
        dateSearchFrame = new JFrame();
        dateSearchFrame.setTitle("Wardrobe Management System: Home");
        dateSearchFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //closes window when X is pressed.
        dateSearchFrame.setSize(192 * 6, 108 * 6);// *10 for 1920 x 1080 pixels
        dateSearchFrame.setResizable(true); //Turn to false if window size needs to be fixed.
        dateSearchFrame.setLocationRelativeTo(null);

        JPanel input = new JPanel();
        input.setBorder(BorderFactory.createEmptyBorder(150,10,10,10));


        //TextBox for setting name
        JTextField nameText = new JTextField(10);//10 specifies width of text field
        nameText.setFont(new Font("Arial",Font.BOLD,26));//The font size changes height of the text field
        nameText.setForeground(Color.BLACK);
        nameText.setBackground(Color.LIGHT_GRAY);
        nameText.setToolTipText("Enter date bought.");
        nameText.setMargin(new Insets(5,10,5,10));
        final boolean[] nameTextClicked = {false};
        nameText.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                date_bought = nameText.getText();
                nameText.setText("Registered!");
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
        infotextPanel.setBorder(BorderFactory.createEmptyBorder(50,10,50,10));

        dateSearchFrame.add(input, BorderLayout.CENTER);
        dateSearchFrame.add(infotextPanel, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10,10,20,10));


        Button buttonDelete = new Button("Search by Date"); //creates button
        buttonDelete.setFont(new Font("Arial",Font.PLAIN,20));
        buttonDelete.setBackground(Color.GREEN); //Too Bright
        buttonDelete.setForeground(Color.WHITE);

        buttonPanel.add(buttonDelete);
        buttonDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //if statement inside this block.
                if(nameTextClicked[0] == true){
                    System.out.println("Valid input detected. searching for values in database.");
                    itemNames = CRUDE.dateSearch(date_bought);
                    infotext.setText(CRUDE.dateSearch(date_bought));
                    System.out.println("New Values are:");
                    CRUDE.showAllItems();
                }
            }
        });

        dateSearchFrame.add(buttonPanel, BorderLayout.SOUTH);

    }

    private void showHomeFrame(){
        initializeHome();
        //Mainframe.invalidate(); Mainframe.validate(); Mainframe.repaint();
        Mainframe.setVisible(true);
    }
    private void hideHomeFrame(){
        Mainframe.setVisible(false);
        Mainframe.dispose();
    }
    private void showInputFrame(){
        intitializeItemInput_add();
        inputFrame.setVisible(true);
    }
    private void HideInputFrame(){
        inputFrame.setVisible(false);
        inputFrame.dispose();
    }
    private void showInputFrame2(){
        intitializeItemInput_modify();
        inputFrame2.setVisible(true);
    }
    private void HideInputFrame2(){
        inputFrame2.setVisible(false);
        inputFrame2.dispose();
    }
    private void showInputFrame3(){
        intitializeItemInput_delete();
        inputFrame3.setVisible(true);
    }
    private void HideInputFrame3(){
        inputFrame3.setVisible(false);
        inputFrame3.dispose();
    }
    private void showInputFrame4(){
        intitializeItemInput_select();
        inputFrame4.setVisible(true);
    }
    private void HideInputFrame4(){
        inputFrame4.setVisible(false);
        inputFrame4.dispose();
    }

    private void showGlobalSearchFrame(){
        intitializeGlobalSearch();
        globalSearchFrame.setVisible(true);

    }
    private void hideGlobalSearchFrame(){
        globalSearchFrame.setVisible(false);
        globalSearchFrame.dispose();

    }
    private void showTypeSearchFrame(){
        intitializeTypeSearch();
        typeSearchFrame.setVisible(true);

    }
    private void hideTypeSearchFrame(){
        typeSearchFrame.setVisible(false);
        typeSearchFrame.dispose();

    }
    private void showHexcodeSearchFrame(){
        intitializeHexcodeSearch();
        hexcodeSearchFrame.setVisible(true);

    }
    private void hideHexcodeSearchFrame(){
        hexcodeSearchFrame.setVisible(false);
        hexcodeSearchFrame.dispose();

    }
    private void showDateSearchFrame(){
        intitializeDateSearch();
        dateSearchFrame.setVisible(true);

    }
    private void hideDateSearchFrame(){
        dateSearchFrame.setVisible(false);
        dateSearchFrame.dispose();

    }
}
