package ru.geekbrains.katebatasheva.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

public class MainApp {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        Scanner scanner = new Scanner(System.in);

        ProductRepository repository = context.getBean("productRepository", ProductRepository.class);
        ProductService service = context.getBean("productService", ProductService.class);

        System.out.println("Доступны следудщие команды: \n1 - добавить \n2 - удалить \n3 - распечатать весь список товаров \n4 - обновить/ изменить цену товара " +
                "\n5 - вывести количество всех товаров \n6 - вывести среднюю цену. " +
                "\nКоманды вводить в следубщем виде с учетом требуемых параметров: (команда) (наименование позиции) (цена)");
        while (scanner.hasNext()) {
            int command = scanner.nextInt();
            String item = scanner.nextLine();
            if (command == Commands.ADD.getCommand()) {
                String[] addItem = item.split(" ");
                service.addProduct(new Product(addItem[1], repository.getProducts().size() + 1, Integer.valueOf(addItem[2])));
                System.out.printf("Товар %s с ценой %s добавлен в лист \n", addItem[1], addItem[2]);
            }
            if (command == Commands.DELETE.getCommand()) {
                String[] deleteItem = item.split(" ");
                Product product = service.getProduct(deleteItem[1]);
                service.deleteProduct(service.getProduct(deleteItem[1]));
            System.out.printf("Товар %s с ценой %s удален из листа \n", product.getTitle(), product.getCost());
        }
        if (command == Commands.READ_ALL.getCommand()) {
            String allList = repository.toString();
            System.out.println(allList);
        }
        if (command == Commands.UPDATE.getCommand()) {
            String [] upd = item.split(" ");
            int cost = service.getProduct(upd[1]).getCost();
            service.getProduct(upd[1]).setCost(Integer.parseInt(upd[2]));
            System.out.printf("Для товара %s изменена цена с %d на %d \n", upd[1], cost, Integer.parseInt(upd[2]));
        }
        if (command == Commands.AMOUNT.getCommand()){
            int amount = repository.getProducts().size();
            System.out.printf("Всего товаров - ", amount);
        }
        if (command == Commands.AVG.getCommand()){
            int avg = service.AVGcost();
            System.out.printf("Средняя цена товаров - ", avg);
        }
    }

            context.close();
}
}
