package metier;

/**
 *
 * @author elliot
 */
public class TypeInconnuException extends Exception {
	public TypeInconnuException() {
		super("le type entré n'est pas reconnu");
	}
}
