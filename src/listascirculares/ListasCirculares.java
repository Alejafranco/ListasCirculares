package listascirculares;

import java.util.Scanner;

public class ListasCirculares {

    public static void main(String[] args) throws Exception {

        /*-------------------LISTA CIRCULAR SIMPLE-------------------*/
        ListaCircularSimple<Integer> listaCircular = new ListaCircularSimple<>();

        //1. Agregar datos ordenados de mayor a menor e impedir datos repetidos.
        listaCircular.addOrdered(55);
        listaCircular.addOrdered(88);
        listaCircular.addOrdered(66);
        listaCircular.addOrdered(11);
        listaCircular.addOrdered(77);
        listaCircular.addOrdered(22);
        System.out.println(listaCircular.showData());

        //2. Recorrer la lista desde un nodo específico hasta el final.
        System.out.println(listaCircular.recorrerDesde(66));

        //3. Unir todos los datos de otra lista circular simple.
        ListaCircularSimple<Integer> newList = new ListaCircularSimple<>();

        newList.addOrdered(3);
        newList.addOrdered(6);
        newList.addOrdered(4);
        newList.addOrdered(1);
        newList.addOrdered(5);
        newList.addOrdered(2);
        newList.joinList(listaCircular);
        System.out.println(newList.showData());

        /*-------------------LISTA CIRCULAR DOBLE-------------------*/
        ListaCircularDoble<Integer> listaCircularDoble = new ListaCircularDoble<>();

        //1. Agregar datos ordenados de menor a mayor e impedir datos repetidos.
        listaCircularDoble.addOrdered(55);
        listaCircularDoble.addOrdered(88);
        listaCircularDoble.addOrdered(66);
        listaCircularDoble.addOrdered(11);
        listaCircularDoble.addOrdered(77);
        listaCircularDoble.addOrdered(22);
        System.out.println(listaCircularDoble.showData());

        //2. Determinar si un dato existe.
        System.out.println(listaCircularDoble.ExistData(66));

        //3. Dividir la lista en dos a partir de un nodo específico. Se retorna una nueva lista con la división resultante.
        System.out.println(listaCircularDoble.DivideList(66).showData());

        /*------------------- CASO PRACTICO -------------------*/
        ListaCircularDoble<String> lista = new ListaCircularDoble<>();
        String name;
        int opcion = 0;
        boolean salir = false;
        while (salir != true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("----- LISTA DE REPRODUCCIÓN DE VIDEO ------");
            System.out.println("1. Agregar video");
            System.out.println("2. Eliminar");
            System.out.println("3. Actualizar");
            System.out.println("4. Ver lista");
            System.out.println("5. Reproducción automática");
            System.out.println("6. Salir");
            System.out.print("Ingrese una opción de 1 a 6: ");
            opcion = sc.nextInt();
            sc = new Scanner(System.in);
            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el nombre del video: ");
                    name = sc.nextLine();
                    lista.add(name);
                    break;
                case 2:
                    System.out.print("Ingrese el nombre del video: ");
                    name = sc.nextLine();
                    lista.deleteVideo(name);
                    break;
                case 3:
                    System.out.print("Ingrese el nombre del video: ");
                    name = sc.nextLine();
                    System.out.print("Ingrese el NUEVO nombre del video: ");
                    String newName = sc.nextLine();
                    lista.actualizar(name, newName);                          
                    break;
                case 4:
                    System.out.println("-Lista actual-");
                    System.out.print(lista.showVideo());
                    break;
                case 5:
                    boolean play = true;
                    String op;
                    while(play != false){
                        lista.reproducir();
                        System.out.print("Fin de lista, ¿Iniciar nuevamente? s/n: ");
                        op = sc.nextLine();
                        play = ("s".equals(op));
                    }
                    break;
                case 6:
                    salir = true;
                    break;
                default:
                    System.out.println("ERROR: Opción no válida");
                    break;
            }
        }
    }

}
