package tobeto_rentAcar.services.abstracts;

import tobeto_rentAcar.data.DTO.VehicleFeaturesDTO.BodyTypeDto;
import tobeto_rentAcar.data.DTO.VehicleFeaturesDTO.BrandDto;
import tobeto_rentAcar.data.DTO.VehicleFeaturesDTO.ColorDto;
import tobeto_rentAcar.data.DTO.VehicleFeaturesDTO.ModelDto;
import tobeto_rentAcar.data.requests.commonRequests.vehicleRequests.vehicleFeaturesRequests.AddBodyTypeReq;
import tobeto_rentAcar.data.requests.commonRequests.vehicleRequests.vehicleFeaturesRequests.AddBrandReq;
import tobeto_rentAcar.data.requests.commonRequests.vehicleRequests.vehicleFeaturesRequests.AddColorReq;
import tobeto_rentAcar.data.requests.commonRequests.vehicleRequests.vehicleFeaturesRequests.AddModelReq;

import java.util.List;

public interface IVehicleFeaturesService {

    //----------------ADD METHODS---------------
    BodyTypeDto addBodyType(AddBodyTypeReq addBodyTypeReq);

    BrandDto addBrand(AddBrandReq addBrandReq);

    ColorDto addColor(AddColorReq addColorReq);

    ModelDto addModel(AddModelReq addModelReq);

    //----------------GET METHODS---------------

    BodyTypeDto getBodyTypeById(int id);

    BrandDto getBrandById(int id);

    ColorDto getColorById(int id);

    ModelDto getModelById(int id);

    List<BodyTypeDto> getAllBodyTypes();

    List<BrandDto> getAllBrands();

    List<ColorDto> getAllColors();

    List<ModelDto> getAllModels();

    //----------------DELETE METHODS---------------
    void deleteBodyTypeById(int id);

    void deleteBrandById(int id);

    void deleteColorById(int id);

    void deleteModelById(int id);

}
