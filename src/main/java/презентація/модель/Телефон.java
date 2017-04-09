package презентація.модель;

import lombok.RequiredArgsConstructor;
import lombok.ToString;

/**
 * Телефон телефоном, нічого особливого.
 * Android > iOS
 */
@RequiredArgsConstructor
@ToString
public class Телефон {
    public final String модель;
    public final Integer рейтинг;
}
