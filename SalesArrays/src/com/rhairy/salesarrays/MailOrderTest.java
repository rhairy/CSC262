import com.rhairy.salesarrays.*;

public class MailOrderTest
{
	public static void main( String [] args )
	{
		MailOrders myOrder = new MailOrders();
		
		myOrder.FillInventory( 1, 10, 1 );
		myOrder.FillInventory( 2, 20, 2 );
		
		MyInventory product1 = myOrder.getInventoryItem( 1 );
		
		if ( product1 == null ) {
			System.out.printf( "Could not find product.\n");
		} else {
			System.out.println( "The product was found!\n");
			System.out.printf( "The product's ProductNum is: %d.\n", product1.getProductNum() );
			System.out.printf( "The product's Price is: %f.\n", product1.getPrice() );
			System.out.printf( "The Product's Qty is: %d.\n", product1.getQty() );
		}
	}
}