package tobeto_rentAcar.services.systemServices;

import java.lang.reflect.Field;

public class EntityUpdaterUtil {

    //TODO burada hata var. postmande entity is null diyor.
    public static <T> T updateEntityFields(T entityy, Object request) {
        Field[] entityyFields = entityy.getClass().getDeclaredFields();

        for (Field entityyField : entityyFields) {
            entityyField.setAccessible(true);

            try {
                Field requestField = request.getClass().getDeclaredField(entityyField.getName());
                requestField.setAccessible(true);

                Object requestValue = requestField.get(request);

                if (requestValue != null) {
                    entityyField.set(entityy, requestValue);
                }
            } catch (NoSuchFieldException | IllegalAccessException e) {
                // Hata durumunu ele al, örneğin: throw new RuntimeException("Alan güncelleme hatası: " + e.getMessage());
            }
        }
        return entityy;
    }

}
