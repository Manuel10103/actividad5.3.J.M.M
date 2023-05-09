package pracAgenda;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.io.File;

public class Principal {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		ArrayList<Contacto> agenda = new ArrayList<>();

		Fecha fx = new Fecha(29, 02, 2004);
		Contacto CX = new Contacto("Javier", "Atochero", "635522799", "Javier22atochero@gmail.com", "71367744P", fx,
				"chico clase");
		agenda.add(CX);

		boolean finju = false;
		int opcion = 0;

		while (finju == false) {
			menu();
			opcion = sc.nextInt();

			switch (opcion) {
			case 1:
				mostrarTodo(agenda);
				break;
			case 2:
				mostrarUno(agenda);
				break;
			case 3:
				mostrarXcaracteres(agenda);
				break;
			case 4:
				crearCon(agenda);
				break;
			case 5:
				eliminarUno(agenda);
				break;
			case 6:
				actualizarUno(agenda);
				break;
			case 0:
				finju = true;
				System.out.println("Finalizando ejecucion...");
				break;
			default:
				System.out.println("El numero seleccionado no esta en el menu, vuelva a introducir un numero..");
				break;
			}
		}

	}

	private static void actualizarUno(ArrayList<Contacto> agenda) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Introduce el numero de telefono del usuario que desea actualizar:");
		String numtlfn = sc.next();
		try {
			for (int i = 0; i < agenda.size(); i++) {
				if (agenda.get(i).getNumtlfn().equals(numtlfn)) {
					System.out.println("Cambiamos a:" + agenda.get(i).getNombre());

					System.out.println("Introduce nombre:");
					String nom = sc.next();
					agenda.get(i).setNombre(nom);

					System.out.println("Introduce apellidos:");
					String ape = sc.next();
					agenda.get(i).setApellidos(ape);

					System.out.println("Introduce numero de telefono:");
					String tlfn = sc.next();
					agenda.get(i).setNumtlfn(numtlfn);

					System.out.println("Introduce su mail:");
					String mail = sc.next();
					agenda.get(i).setMail(mail);

					System.out.println("Introduce su dni:");
					String dni = sc.next();
					agenda.get(i).setDni(dni);

					System.out.println("Introduce su fecha de nacimiento para ello...");
					System.out.println("Introduce su año de nacimiento:");
					int anio = sc.nextInt();
					agenda.get(i).getFechanac().setAno(anio);

					System.out.println("Introduce su mes de nacimiento:");
					int mes = sc.nextInt();
					agenda.get(i).getFechanac().setMes(mes);

					System.out.println("Introduce su dia de nacimiento:");
					int dia = sc.nextInt();
					agenda.get(i).getFechanac().setDia(dia);

					System.out.println("Introduce una descripcion conta para este:");
					String desc = sc.next();
					agenda.get(i).setDesc(desc);

					System.out.println("Usuario cambiado con exito.");
					agenda.get(i).toString();

				} else {
					System.out.println("Numero inexistente.");
				}
			}
		} catch (Exception e) {
			System.out.println("Algo no funcionó correctamente..");
		}

	}

	private static void eliminarUno(ArrayList<Contacto> agenda) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Introduce el numero de telefono del usuario:");
		String numtlfn = sc.next();

		try {
			for (int i = 0; i < agenda.size(); i++) {
				if (agenda.get(i).getNumtlfn().equals(numtlfn)) {
					agenda.remove(i);
					System.out.println("Contacto " + agenda.get(i).getNombre() + " eliminado.");
				} else {
					System.out.println("Numero inexistente.");
				}
			}
		} catch (Exception e) {
			System.out.println("Algo no funcionó correctamente..");
		}
	}

	private static void crearCon(ArrayList<Contacto> agenda) {
		Scanner sc = new Scanner(System.in);
		if (agenda.size() >= 20) {
			System.out.println("Agenda llena.");
			System.out.println("¿Quieres reemplazar algun contacto?");
			System.out.println("1.Si");
			System.out.println("2.No");
			int opcion = sc.nextInt();

			if (opcion == 1) {
				System.out.println("Introduce numtlfn:");
				String numnue = sc.next();
				for (int i = 0; i < agenda.size(); i++) {
					if (agenda.get(i).getNumtlfn().equals(numnue)) {
						agenda.remove(i);
						nuevo(agenda);
					}
				}
			}
		} else {
			nuevo(agenda);
		}

	}

	private static void nuevo(ArrayList<Contacto> agenda) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce nombre:");
		String nom = sc.next();
		System.out.println("Introduce apellidos:");
		String ape = sc.next();
		System.out.println("Introduce numero de telefono:");
		String tlfn = sc.next();
		System.out.println("Introduce su mail:");
		String mail = sc.next();
		System.out.println("Introduce su dni:");
		String dni = sc.next();
		System.out.println("Introduce su fecha de nacimiento para ello...");
		System.out.println("Introduce su año de nacimiento:");
		int anio = sc.nextInt();
		System.out.println("Introduce su mes de nacimiento:");
		int mes = sc.nextInt();
		System.out.println("Introduce su dia de nacimiento:");
		int dia = sc.nextInt();
		System.out.println("Introduce una descripcion conta para este:");
		String desc = sc.next();

		Fecha fn = new Fecha(dia, mes, anio);
		Contacto cn = new Contacto(nom, ape, tlfn, mail, dni, fn, desc);
		agenda.add(cn);

	}

	private static void mostrarXcaracteres(ArrayList<Contacto> agenda) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce los caracteres que empiece.");
		String car = sc.next().toLowerCase();
		for (int i = 0; i < agenda.size(); i++) {
			if (agenda.get(i).getNombre().toLowerCase().contains(car)) {
				System.out.println(agenda.get(i));
			}
		}

	}

	private static void mostrarUno(ArrayList<Contacto> agenda) {
		Scanner sc = new Scanner(System.in);

		System.out.println("¿De qué contacto quieres ver la información");
		System.out.println("Introduce su DNI o numero de teléfono");
		String opcion = sc.next();

		for (int i = 0; i < agenda.size(); i++) {
			if (opcion.equals(agenda.get(i).numtlfn)) {
				System.out.println(agenda.get(i));
			} else if (opcion.equals(agenda.get(i).getDni())) {
				System.out.println(agenda.get(i));
			} else {
				System.out.println("No existente.");
			}
		}

	}

	private static void mostrarTodo(ArrayList<Contacto> agenda) {
		ArrayList<Contacto> auxo = new ArrayList<>();
		auxo.addAll(agenda);
		Collections.sort(auxo, Comparator.comparing(Contacto::getNombre));

		for (int i = 0; i < auxo.size(); i++) {
			int edad = edadauto(i, auxo);
			System.out.println(auxo.get(i).getNombre() + " " + auxo.get(i).getApellidos() + " " + edad);
		}

	}

	private static int edadauto(int i, ArrayList<Contacto> agenda) {
		int dia = LocalDate.now().getDayOfMonth();
		int mes = LocalDate.now().getMonthValue();
		int anio = LocalDate.now().getYear();
		int edad = 0;

		Fecha ahora = new Fecha(dia, mes, anio);

		edad = ahora.getAno() - agenda.get(i).getFechanac().getAno();

		return edad;
	}

	private static void menu() {
		System.out.println("--------------------------------------");
		System.out.println("1.Mostrar todos los contactos.");
		System.out.println("2.Mostrar un contacto.");
		System.out.println("3.Mostrar contacto por caracteres");
		System.out.println("4.Crear nuevo contacto.");
		System.out.println("5.Eliminar contacto.");
		System.out.println("6.Actualizar Contacto.");
		System.out.println("______________________________________");
		System.out.println("0.Para finalizar ejecucion.");
		System.out.println("--------------------------------------");
	}

}
