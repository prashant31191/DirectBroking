package directbroking.client;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
	static final String dbName = "DirectBrokingDB";
	static final String portfolioTable = "Portfolio";
	static final String ordersTable = "CompletedOrders";
	static final String accountTable = "Account";

	static final String colTicker = "Code";
	public static final String COLUMN_ID = "_id";
	static final String colQuantity = "Quantity";
	static final String colCostPrice = "CostPrice";
	static final String colMarketPrice = "Price";

	static final String colMarketValue = "Value";
	static final String colUnrealisedPL = "UnrealisedPL";
	static final String colValueNZD = "ValueNZD";
	static final String colUnrealisedPLNZD = "UnrealisedPLNZD";
	static final String colPercentPortfolio = "PercentPortfolio";
	static final String colLastOrder = "LastOrder";
	
	static final String colAccountName = "Description";
	static final String colCCY = "CCY";
	static final String colBalance = "Balance";
	static final String colInterestRate = "InterestRate";
	
	private static final String PORTFOLIO_TABLE_CREATE = "create table "
	        + portfolioTable
	        + " ("
	        + COLUMN_ID + " integer primary key autoincrement , "
	        + colTicker + " TEXT , "
	        + colQuantity + " INTEGER , "
	        + colCostPrice + " INTEGER , "
	        + colMarketPrice + " INTEGER , "
	        + colMarketValue + " INTEGER , "
	        + colUnrealisedPLNZD + " INTEGER"
	        + ");";
	private static final String ORDERS_TABLE_CREATE = "create table "
			+ ordersTable
			+"("
			+ COLUMN_ID + " integer primary key autoincrement , "
			+ colTicker + " TEXT , "
			+ colLastOrder + " TEXT , "
			+ colQuantity + " INTEGER"
			+ ");";
	
	private static final String ACCOUNT_TABLE_CREATE = "create table "
			+ accountTable
			+"("
			+ COLUMN_ID + " integer primary key autoincrement , "
			+ colAccountName + " TEXT , "
			+ colCCY + " TEXT , "
			+ colBalance + " TEXT , "
			+ colInterestRate + " TEXT"
			+ ");";

	public DatabaseHelper(Context context) {
		super(context, dbName, null, 48);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
	    db.execSQL(PORTFOLIO_TABLE_CREATE);
	    db.execSQL(ORDERS_TABLE_CREATE);
	    db.execSQL(ACCOUNT_TABLE_CREATE);
	}

	@Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("DROP TABLE IF EXISTS " + portfolioTable);
		db.execSQL("DROP TABLE IF EXISTS " + ordersTable);
		db.execSQL("DROP TABLE IF EXISTS " + accountTable);
		onCreate(db);
	}
	
	public void deleteAllEntries(SQLiteDatabase db){
		db.delete(portfolioTable, null, null);
		db.delete(ordersTable, null, null);
		db.delete(accountTable, null, null);
	}
}