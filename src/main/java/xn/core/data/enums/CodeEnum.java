package xn.core.data.enums;

import xn.core.data.enums.interfaces.ICodeEnum;

/**
 * @Description:获取下来cdcode名称
 * @author Zhangjc
 * @date 2016年5月13日 下午1:44:32
 */
public enum CodeEnum implements ICodeEnum {

    PIG_TYPE_NAME( "PIG_TYPE", "pigType","pigTypeName"),
    PIG_SEX_NAME("PIG_SEX", "sex", "sexName"),
    MATERIAL_TYPE_NAME("MATERIAL_TYPE", "materialType", "materialTypeName"),
    CREATE_SWINERY_TYPE("CREATE_SWINERY_TYPE", "createType", "createSwineryTypeName"),
    EVENT_NAME("EVENT_NAME", "eventName", "eventNameChinese"),
    EVENT_CODE("EVENT_NAME", "eventCode", "eventNameChinese"),
    SEMEN_COLOR("SEMEN_COLOR", "color", "semenColorName"),
    SEMEN_ODOUR("SEMEN_ODOUR", "odour", "semenOdourName"),
    COHESION("COHESION", "cohesion", "cohesionName"),
    LABER_CHANGE_TYPE("LABER_CHANGE_TYPE", "changeType", "changeTypeName"),
    BREED_TYPE("BREED_TYPE", "breedType", "breedTypeName"),
    PREGNANCY_RESULT ("PREGNANCY_RESULT", "pregnancyResult", "pregnancyResultName"),
    PREGNANCY_TYPE ("PREGNANCY_TYPE", "pregnancyType", "pregnancyTypeName"),
    DELIVERY_TYPE("DELIVERY_TYPE", "deliveryType", "deliveryTypeName"),
    FOSTER_REASON("FOSTER_REASON", "fosterReason", "fosterReasonName"),
    OBSOLETE_REASON("OBSOLETE_REASON", "leaveReason", "obsoleteReasonName"),
    GOOD_DIE_REASON("GOOD_DIE_REASON", "obsoleteReason", "dieReasonName"),
    BOAR_DIE_REASON("BOAR_DIE_REASON", "obsoleteReason", "dieReasonName"),
    CHILD_CARE_CHANGE_TYPE("CHILD_CARE_CHANGE_TYPE", "changeHouseType", "changeHouseTypeName"),
    FATTEN_CHANGE_TYPE("FATTEN_CHANGE_TYPE", "fattenChangeType", "changeHouseTypeName"),
    SELL_TYPE("SELL_TYPE", "sellType", "sellTypeName"),
    SELL_GOOD("SELL_GOOD", "sellGood", "sellGoodName"),
    IS_USE_BDATE("IS_USE_BDATE", "isUseBdate", "isUseBdateName"), 
    EMPLOYEE_TYPE("EMPLOYEE_TYPE", "employeeType", "employeeTypeName"),
    CREATE_SUP_TYPE("CREATE_SUP_TYPE","createType","createTypeName"),
    CREATE_CUS_TYPE("CREATE_CUS_TYPE", "createType", "createTypeName"),
    CITY("CITY", "city", "cityName"),
    PROVINCE("PROVINCE", "province", "provinceName"),
    COUNTY("COUNTY", "county", "countyName");
    
    private final String typeCode;
    private final String codeId;
    private final String codeName;

    CodeEnum(String typeCode, String id, String codeName) {
        this.codeId = id;
        this.typeCode = typeCode;
        this.codeName = codeName;
    }

    @Override
    public String getCodeId() {
        return codeId;
    }

    @Override
    public String getTypeCode() {
        return typeCode;
    }

    @Override
    public String getCodeName() {
        return codeName;
    }
}
