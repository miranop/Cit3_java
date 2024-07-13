package db;

public class AppearMain {
	void insert(int number, int shicode) {
		AppearDAO appearDAO = new AppearDAO();
		boolean success = appearDAO.insert(number, shicode);
		System.out.println(success);
	}

	void delete(int id) {
		AppearDAO appearDAO = new AppearDAO();
		boolean success = appearDAO.delete(id);
		System.out.println(success);
	}

	public static void main(String args[]) {
		AppearMain main = new AppearMain();
		main.insert(6, 12206);
		main.delete(5);
	}
}