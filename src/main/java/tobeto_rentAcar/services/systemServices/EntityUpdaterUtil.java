package tobeto_rentAcar.services.systemServices;

import java.lang.reflect.Field;

public class EntityUpdaterUtil {

    public static void updateEntityFields(Object entity, Object request) {
        Field[] entityFields = entity.getClass().getDeclaredFields();

        for (Field entityField : entityFields) {
            entityField.setAccessible(true);

            try {
                Field requestField = request.getClass().getDeclaredField(entityField.getName());
                requestField.setAccessible(true);

                Object requestValue = requestField.get(request);

                if (requestValue != null) {
                    entityField.set(entity, requestValue);
                }
            } catch (NoSuchFieldException | IllegalAccessException e) {
                // Hata durumunu ele al, örneğin: throw new RuntimeException("Alan güncelleme hatası: " + e.getMessage());
            }
        }
    }
}
