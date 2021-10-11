/** 	Write an application for Lambert’s Vacation Rentals. Use separate  ButtonGroups to allow a client to select one of three locations, the number of bedrooms,
and whether meals are included in the rental. Assume that the locations are parkside for $600 per week, poolside for $750 per week, or lakeside for $825 per week.
Assume that the rentals have one, two, or three bedrooms and that each bedroom over one adds $75 to the base price. Assume that if meals are added, the price is $200
more per rental. Save the file as JVacationRental.**/

import java.awt.event.ActionEvent; 

import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;



public class JVacationRental extends JFrame implements ActionListener {
	private final int PARK_SIDE = 600;
	   private final int POOL_SIDE = 750;
	   private final int LAKE_SIDE = 825;

	   private final int ONE_BEDROOM = 75;
	   private final int TWO_BEDROOMS = 150;
	   private final int THREE_BEDROOMS = 225;

	   private final int MEALS = 200;

	   // setting labels

	   private JLabel Location = new JLabel("LOCATION: ");
	   private JLabel Bedrooms = new JLabel("BEDROOMS: ");
	   private JLabel Meals = new JLabel("INCLUDE MEALS: ");

	   // setting button variables and designing buttons
	   private JRadioButton park_s= new JRadioButton("PARK SIDE");
	   private JRadioButton pool_s = new JRadioButton("POOL SIDE");
	   private JRadioButton lake_s = new JRadioButton("LAKE SIDE");

	   private JRadioButton c1 = new JRadioButton("1");
	   private JRadioButton c2 = new JRadioButton("2");
	   private JRadioButton c3 = new JRadioButton("3");

	   private JRadioButton Yes = new JRadioButton("YES"); 
	   private JRadioButton No = new JRadioButton("NO"); 

	   // location bedroom and meals button
	   private ButtonGroup group1 = new ButtonGroup();
	   private ButtonGroup group2 = new ButtonGroup();
	   private ButtonGroup groupMeals = new ButtonGroup();

	   // button to calculate and result
	   private JButton Calculate_ = new JButton(" CALCULATE TOTAL RENT");
	   private JButton Reset = new JButton("RESET ");

	   // button for total rent
	   private JLabel result = new JLabel("TOTAL RENT: $ 0.0");

	   // panel setting with the corresponding variables
	   private JPanel _Locations_ = new JPanel();
	   private JPanel Bedrooms_ = new JPanel();
	   private JPanel Meals_ = new JPanel();
	   private JPanel _Button_ = new JPanel();
	   private JPanel Label = new JPanel();
	   private JPanel panel = new JPanel();

	   // initializing the cost
	   private int locationRent = 0;
	   private int bedroomsRent = 0;
	   private int mealsCost = 0;
	
	public JVacationRental() {
		super("Vacation Rentals ");
		setSize(400,500);

	       // adding frames for the variables
	       group1.add(park_s);
	       group1.add(pool_s);
	       group1.add(lake_s);

	       group2.add(c1);
	       group2.add(c2);
	       group2.add(c3);

	       groupMeals.add(Yes);
	       groupMeals.add(No);

	       _Locations_.add(Location);
	       _Locations_.add(park_s);
	       _Locations_.add(pool_s);
	       _Locations_.add(lake_s);

	       Bedrooms_.add(Bedrooms);
	       Bedrooms_.add(c1);
	       Bedrooms_.add(c2);
	       Bedrooms_.add(c3);

	       Meals_.add(Meals);
	       Meals_.add(Yes);
	       Meals_.add(No);

	       _Button_.add(Calculate_);
	       _Button_.add(Reset);
	        Label.add(result);

	       panel.add(_Locations_);
	       panel.add(Bedrooms_);
	       panel.add(Meals_);

	       panel.add(_Button_);
	       panel.add(Label);

	       // adding panel

	       add(panel);

	       park_s.addItemListener(new LocationsListener());
	       pool_s.addItemListener(new LocationsListener());
	       lake_s.addItemListener(new LocationsListener());

	       c1.addItemListener(new BedroomsListener());
	       c2.addItemListener(new BedroomsListener());
	       c3.addItemListener(new   BedroomsListener());

	       Yes.addItemListener(new MealsListener());
	       No.addItemListener(new MealsListener());

	       Calculate_.addActionListener(this);
	       Reset.addActionListener(this);
	       setVisible(true);
	       
	       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	   // setting action which has to be performed

	   public void actionPerformed(ActionEvent e)

	   {

	       Object source = e.getSource();

	       if (source == Calculate_){

	           // calculating the rental value.
	           double totalRent1 = locationRent + bedroomsRent + mealsCost;

	           // displaying rental amount
	           result.setText("TOTAL RENT: $ " + totalRent1);
	       } else if (source == Reset)   {

	           group1.clearSelection();
	           group2.clearSelection();
	           groupMeals.clearSelection();

	           result.setText("Total Rent: $ 0.0");

	           // setting initial value =0
	           locationRent = 0;
	           bedroomsRent = 0;
	           mealsCost = 0;
	       }
	   }

	   private class LocationsListener implements ItemListener   {

	       public void itemStateChanged(ItemEvent e) {

	           Object source = e.getItem();
	           if (source == park_s)
	               locationRent = PARK_SIDE;
	           else if (source == pool_s)
	               locationRent = POOL_SIDE;
	           else if (source == lake_s)
	               locationRent = LAKE_SIDE;
	           else
	               locationRent = 0;
	       }
	   }

	   private class BedroomsListener implements ItemListener {
		   @Override
	       public void itemStateChanged(ItemEvent e) {

	           Object source = e.getItem();
	           if (source == c1)
	               bedroomsRent = ONE_BEDROOM;
	           else if (source == c2)
	               bedroomsRent = TWO_BEDROOMS;
	           else if (source == c3)
	               bedroomsRent = THREE_BEDROOMS;
	           else
	               bedroomsRent = 0;
	       }
	   }

	   private class MealsListener implements ItemListener   {

	       public void itemStateChanged(ItemEvent e) {

	           Object source = e.getItem();
	           if (source == Yes)
	               mealsCost = MEALS;
	           else if (source == No)
	               mealsCost = 0;
	           else
	               mealsCost = 0;
	       }
	   }

	}
	
