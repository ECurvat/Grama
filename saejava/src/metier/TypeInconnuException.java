package metier;

/**
 *
 * @author François, Elliot
 */
public class TypeInconnuException extends Exception {
	public TypeInconnuException() {
		super("le type entré n'est pas reconnu");
	}
}
