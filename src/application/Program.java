package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat ("dd/MM/yyyy");
		
		System.out.println("Digite os dados do cliente: ");
		System.out.print("Nome: ");
		String name = sc.nextLine();
		System.out.print("Email: ");
		String email = sc.nextLine();
		System.out.print("Data de nascimento (DD/MM/YYYY): ");
		Date birthDate = sdf.parse(sc.next());
		
		Client client = new Client(name, email, birthDate);
		
		System.out.println("Digite os dados dos pedido: ");
		System.out.println("Etapa:");
		OrderStatus status = OrderStatus.valueOf(sc.next());
		
		Order order = new Order (new Date(), status,client);
		
		System.out.print("Quantos itens para este pedido? ");
		int n = sc.nextInt();
		for (int i=1; i<=n; i++) {
			System.out.println("Digite os dados do item " + i);
			System.out.print("nome do Produto: ");
			sc.nextLine();
			String productName = sc.nextLine();
			System.out.println("Preço do produto: ");
			double productPrice = sc.nextDouble();
			
			Product product = new Product(productName, productPrice);
			
			System.out.print("Quantidade: ");
			int quantity = sc.nextInt();
			
			OrderItem orderItem = new OrderItem(quantity, productPrice, product );
			order.addItem(orderItem);
		}
		
		System.out.println();
		System.out.println("Resumo do Pedido:");
		System.out.println(order);
				
		sc.close();	
	}
}
