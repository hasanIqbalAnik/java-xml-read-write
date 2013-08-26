public class Main{
	public static void main(String argv[]) throws Exception{

		print("Welcome to simple library management system");
		

		//SearchBook sb = new SearchBook();
		WriteXMLFile write = new WriteXMLFile();
		write.AddBook("18dsae2", "The alchemist","hasan iqbal");

		ReadXMLFile read = new ReadXMLFile();
		read.SearchBookByIsbn("i18");
		
	}

	public static void print(String str){
		System.out.println(str);
	}


}
