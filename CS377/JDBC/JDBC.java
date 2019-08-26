// THIS CODE IS MY OWN WORK, IT WAS WRITTEN WITHOUT CONSULTING A TUTOR OR CODE 
// WRITTEN BY OTHER STUDENTS - Joseph Barbati

// Don't have to CTRL-C to close, can also use X button.

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

import java.text.DecimalFormat;

import java.sql.*;

/**
 * @author Joseph Barbati
*/
public class JDBC
{
	private       JFrame            mainFrame   = new JFrame("Joseph Barbati's JDBC GUI Fall 2016");
	private       JLabel            dbLabel     = new JLabel("Database: ");
	private       JTextField        dbField     = new JTextField("companyDB");
	private       JButton           selectBtn   = new JButton("Select");
	private       JButton           executeBtn  = new JButton("Execute");
	private       JLabel            columnLabel = new JLabel("Column: ");
	private       JTextField        columnField = new JTextField(2);
	private       JTextField        maxText     = new JTextField();
	private       JButton           maxBtn      = new JButton("Maximum");
	private       JTextField        minText     = new JTextField();
	private       JButton           minBtn      = new JButton("Minimum");
	private       JTextField        avgText     = new JTextField();
	private       JButton           avgBtn      = new JButton("Average");
	private       JTextField        medText     = new JTextField();
	private       JButton           medBtn      = new JButton("Median");
	private       JTextArea         input       = new JTextArea();
	private       JTextArea         output      = new JTextArea();
	private final String            URL         = "jdbc:mysql://holland.mathcs.emory.edu:3306/";
	private final String            USER        = "cs377";
	private final String            PWRD        = "abc123";
	private       Connection        conn;
	private       Statement         stmt;
	private       ResultSet         result;
	private       ResultSetMetaData metaData;
	
	public static void main(String[] args)
	{
	
		JDBC prog = new JDBC();
		
		EventQueue.invokeLater( new Runnable() 
		{
			@Override
			public void run()
			{
				prog.create();
				prog.mainFrame.setVisible(true);
				prog.mainFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		
		// Closes connection and statement on CTRL-C keypress
		Runtime.getRuntime().addShutdownHook( new Thread( new Runnable()
		{
			@Override
			public void run()
			{
				try
				{
					if (!(prog.stmt == null))
						prog.stmt.close();
				}
				catch (SQLException e)
				{
					prog.addOutputText(prog.buildString(e.getMessage()));	
				}
				try
				{
					if (!(prog.conn == null))
						prog.conn.close();
				}
				catch (SQLException e)
				{
					prog.addOutputText(prog.buildString(e.getMessage()));	
				}
			}
		}, "Shutdown-thread") );
		
		// Closes connection and statement on a window-close event
		prog.mainFrame.addWindowListener( new WindowAdapter() 
		{
			@Override
			public void windowClosing(WindowEvent e)
			{
				try
				{
					if (!(prog.stmt == null))
						prog.stmt.close();
				}
				catch (SQLException error)
				{
					prog.addOutputText(prog.buildString(error.getMessage()));	
				}
				try
				{
					if (!(prog.conn == null))
						prog.conn.close();
				}
				catch (SQLException error)
				{
					prog.addOutputText(prog.buildString(error.getMessage()));	
				}
			}
		});
	}

	/**
	 * Creates GUI by adding components to frame and making them all visible
	 * Components taken from GUI code given by Cheung, modified a bit.
	*/
	public void create()
	{
		JPanel mainPanel       = new JPanel();
		JPanel topSidePanel    = new JPanel();
		JPanel bottomSidePanel = new JPanel();
		JPanel colSidePanel    = new JPanel();
		JPanel topPanel        = new JPanel();
		JPanel bottomPanel     = new JPanel();

		Font   courier         = new Font("Courier", Font.BOLD, 16);

		// Setting up top-right area of GUI
		topSidePanel.setLayout( new GridLayout(10, 1) );
		putSpacing(topSidePanel, 1);
		topSidePanel.add(dbLabel);
		topSidePanel.add(dbField);
		topSidePanel.add(selectBtn);
		putSpacing(topSidePanel, 2);
		topSidePanel.add(executeBtn);
		dbField.setFont(courier);
		topSidePanel.setPreferredSize( new Dimension(140, 30) );

		// Setting up input text area
		JScrollPane inputScroll = new JScrollPane(input, 
												  JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
												  JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		// Adds Line #s to input (Class from GitHub).
		// https://github.com/jfacorro/clojure-lab/blob/master/src/java/lab/ui/swing/TextLineNumber.java#L442
		TextLineNumber lineNums  = new TextLineNumber(input);
		inputScroll.setRowHeaderView(lineNums);
		input.setFont(courier);

		// Setting up the top panel
		topPanel.setLayout( new BorderLayout() );
		topPanel.add(inputScroll,  "Center");
		topPanel.add(topSidePanel, "East");
		putSpacing(topPanel, "West");

		// Setting up bottom-right area of GUI
		colSidePanel.add(columnLabel);
		colSidePanel.add(columnField);
		columnField.setFont(courier);

		bottomSidePanel.setLayout(new GridLayout(10, 1) );
		bottomSidePanel.add(colSidePanel);
		putSpacing(bottomSidePanel, 1);
		// Max
		bottomSidePanel.add(maxText);
		maxText.setFont(courier);
		maxText.setEditable(false);
		bottomSidePanel.add(maxBtn);
		// Min
		bottomSidePanel.add(minText);
		minText.setFont(courier);
		minText.setEditable(false);
		bottomSidePanel.add(minBtn);
		// Avg
		bottomSidePanel.add(avgText);
		avgText.setFont(courier);
		avgText.setEditable(false);
		bottomSidePanel.add(avgBtn);
		// Med
		bottomSidePanel.add(medText);
		medText.setFont(courier);
		medText.setEditable(false);
		bottomSidePanel.add(medBtn);

		bottomSidePanel.setPreferredSize( new Dimension(140, 30) );

		// Setting up output text area
		JScrollPane outputScroll = new JScrollPane(output, 
                                       			   JScrollPane.VERTICAL_SCROLLBAR_ALWAYS ,
                                       			   JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		output.setFont(courier);
		output.setEditable(false);

		// Setting up Bottom Panel
		bottomPanel.setLayout( new BorderLayout() );
		bottomPanel.add(outputScroll,    "Center");
		bottomPanel.add(bottomSidePanel, "East");
		putSpacing(bottomPanel, "West");

		// Setting up main Panel
		mainPanel.setLayout( new GridLayout(2, 1) );
		mainPanel.add(topPanel);
		mainPanel.add(bottomPanel);

		// Setting up main Frame
		mainFrame.getContentPane().add(mainPanel);
		mainFrame.setSize(1000, 700);
		
		//Action Listeners
		
		selectBtn.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				try
				{	
					select(e);
				}
				catch (Exception error)
				{
					resetOutputText();
					addOutputText(buildString(error.getMessage()));
				}
			}
		});
		
		executeBtn.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				try
				{
					execute(e);
				}	
				catch (SQLException error)
				{
					System.out.println("EXCEPTION");
					resetOutputText();
					addOutputText(buildString(error.getMessage()));
				}
			}
		});

		minBtn.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				try
				{
					find(e, "min");
				}
				catch (SQLException error)
				{
					minText.setText(error.getMessage());
				}
			}
		});
				
		maxBtn.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				try
				{
					find(e, "max");
				}
				catch (SQLException error)
				{
					maxText.setText(error.getMessage());
				}
			}
		});

		avgBtn.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				try
				{
					find(e, "avg");
				}
				catch (SQLException error)
				{
					avgText.setText(error.getMessage());
				}
			}
		});

		medBtn.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				try
				{
					find(e, "med");
				}
				catch (SQLException error)
				{
					medText.setText(error.getMessage());
				}
			}
		});
	}

	/**
	 * @param text String of text to append to the output text area
	*/
	private void addOutputText(String text)
	{
		output.append(text);
	}
	
	private void resetOutputText()
	{
		output.setText("");
	}

	/**
	 * Adds spacing to the specified JPanel (requires GridLayout)
	 * @param p JPanel to add spacing to
	 * @param num Number of times to add spacing
	*/
	private static void putSpacing(JPanel p, int num)
	{
		for(int i = 0; i < num; i++)
			p.add( new JLabel("            ") );
	}

	/**
	 * Adds spacing to the specified JPanel (requires BorderLayout)
	 * @param p JPanel to add spacing to
	 * @param pos String of the position to add spacing ("West", "East", "North", "South")
	*/
	private void putSpacing(JPanel p, String pos)
	{
		p.add(new JLabel(" "), pos);
	}
	
	private String buildString(String s)
	{
		String[] sArr = s.split(" ");
		String result = "";
		
		for(int i = 0; i < sArr.length; i++)
		{
			result += sArr[i] + " ";
			if (i % 15 == 12) 
				result += "\n";
		}
		
		return result;
	}
	
	private String truncate(String s)
	{
		String res = "";
		for(int i = 0; i < 10; i++)
		{
			res += s.charAt(i);
		}
		return res;
	}
	
	/**
	 * Gets connection to the database
	 * @param e ActionEvent from ActionListener
	*/
	private void select(ActionEvent e)
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
		}
		catch (ClassNotFoundException error)
		{
			addOutputText(buildString(error.getMessage()));
		}
		
		try
		{
			String dbName = dbField.getText();
			
			conn = DriverManager.getConnection(URL+dbName, USER, PWRD);	
			resetOutputText();					
			addOutputText("Database " + dbName + " selected.");
		}
		catch (SQLException error)
		{
			resetOutputText();
			addOutputText(buildString(error.getMessage()));
		}
	}
	
	/**
	 * Gets query and executes query
	 * @param e ActionEvent from ActionListener
	*/
	private void execute(ActionEvent e) throws SQLException
	{
		try
		{
			if (conn != null)
				stmt = conn.createStatement();
			else {
				addOutputText(buildString("Can't submit a query without " + 
										  "selecting a database."));
				return;
			}
		}
		catch (SQLException error)
		{
			resetOutputText();
			addOutputText(buildString(error.getMessage()));
		}
		
		try
		{
			// Closes previously opened result set
			// Allows for finding min, max, avg, and med
			// for each set until another is executed.
			if (result != null) result.close();
			
			result   = stmt.executeQuery(input.getText());
			metaData = result.getMetaData();
		}
		catch (SQLException error)
		{
			resetOutputText();
			addOutputText(buildString(error.getMessage()));
			return;
		}
		
		resetOutputText();
		
		int numCols  = metaData.getColumnCount();
		
		int[] length = new int[numCols];
		
		for (int i = 1; i <= numCols; i++)
		{
			String name = metaData.getColumnName(i);
			
			int type = metaData.getColumnType(i);
			int displaySize = metaData.getColumnDisplaySize(i);
			
			if (name.length() > 10)
			{
				name = truncate(name);
			}
			
			if (type == 3 || type == 4)
				if (displaySize > 10)
					length[i - 1] = 10;
				else 
					length[i - 1] = Math.max(6, name.length());
			else
				length[i - 1] = Math.max(6, displaySize) + 1;
			
			addOutputText(name);	
				
			for(int j = name.length(); j < length[i - 1]; j++)
				addOutputText(" ");
				
			if (type == 3 || type == 4)
				addOutputText(" ");
		}
		addOutputText("\n");
		
		// Dividing line
		for(int i = 1; i <= numCols; i++)
		{
			int type = metaData.getColumnType(i);
			
			for(int j = 0; j < length[i - 1]; j++)
			{
				if (type != 3 && type != 4)
				{
					if (j != length[i - 1] - 1)
						addOutputText("-");
				}
				else
				{
					if (j != length[i - 1])
						addOutputText("-");
				}
			}
			addOutputText(" ");
		}
		addOutputText("\n");
		
		while(result.next())
		{
			for(int i = 1; i <= numCols; i++)
			{
				String item = result.getString(i);
				
				if (item == null) item = "NULL";
				
				int type = metaData.getColumnType(i);
				
				boolean isPadded = false;
				
				// Align right if NUMERIC type
				if (type == 3 || type == 4)
				{
					for(int j = item.length(); j < length[i - 1]; j++)
						addOutputText(" ");
					isPadded = true;
				}
				
				addOutputText(item);
				
				addOutputText(" ");
				if (!isPadded)
					for(int j = item.length(); j < length[i - 1] - 1; j++)
						addOutputText(" ");
			}
			addOutputText("\n");
		}
	}
	
	/**
	 * Finds either min, max, avg, or med
	 * @param what String representation of the four possibilities
	*/
	private void find(ActionEvent e, String what) throws SQLException
	{
		List<String> info;
		int          numCols;
		String       colNum;
		int          colWant;
		try
		{
			info    = new ArrayList<>();
			numCols = metaData.getColumnCount();
			colNum  = columnField.getText();
			colWant = Integer.parseInt(colNum);
		}
		catch (Exception error)
		{
			throw new SQLException("Error");
		}
		
		if (numCols < colWant) throw new SQLException("Error");
		
		int type    = metaData.getColumnType(colWant);
		
		result.beforeFirst(); // resetting pointer
		
		String item;
		while (result.next())
		{
			// Adding each wanted element into List
			item = result.getString(colWant);
			if (item != null){
				info.add("" + item);
			}
		}
		
		// Moving list into array
		String[] infoStr  = null;
		Double[] infoDoub = null;
		if (type == 3 || type == 4)
		{
			infoDoub = new Double[info.size()];
			for (int i = 0; i < infoDoub.length; i++)
				infoDoub[i] = Double.parseDouble(info.get(i));
		}
		else
			infoStr  = info.toArray(new String[info.size()]); 
			
		// Sorting makes things much easier
		if (infoDoub == null)
			Arrays.sort(infoStr);
		else 
			Arrays.sort(infoDoub);
		
		// If user wants average of String type, throw exception
		if (what.equals("avg") && infoStr != null) 
			throw new SQLException("Illegal");
		else if (what.equals("avg"))
		{
			Double sum = new Double(0.0);
			Double len = new Double(infoDoub.length);
			for(int i = 0; i < len; i++)
				sum += infoDoub[i];
			Double avg = sum / len;
			DecimalFormat df = new DecimalFormat("#.##");
			avgText.setText(df.format(avg) + "");
		}
		else if (what.equals("min"))
		{
			if (infoStr == null)
			{
				minText.setText(infoDoub[0] + "");
			}
			else 
			{
				minText.setText(infoStr[0]);
			}
		}	
		else if (what.equals("max"))
		{
			if (infoStr == null)
			{
				maxText.setText(infoDoub[infoDoub.length - 1] + "");
			}
			else 
			{
				maxText.setText(infoStr[infoStr.length - 1]);
			}
		}
		else if (what.equals("med"))
		{
			if (infoStr == null)
			{
				medText.setText(infoDoub[infoDoub.length / 2] + "");
			}
			else 
			{
				medText.setText(infoStr[infoStr.length / 2]);
			}
		}
	}
}