package mikac_tech.clearline.constants;
import java.util.Arrays;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public enum OrderStatus {
    RESERVED("RES"),
    REJECTED("REJ");

    private final String code;
    
    // Cached map initialized once at startup
    private static final Map<String, OrderStatus> LOOKUP = Arrays.stream(values())
            .collect(Collectors.toUnmodifiableMap(OrderStatus::getCode, Function.identity()));

    OrderStatus(String code) {
        this.code = code;
    }

    public String getCode() { return code; }

    // Safe, O(1) reverse-lookup method
    public static Optional<OrderStatus> fromCode(String code) {
        return Optional.ofNullable(LOOKUP.get(code));
    }
}