package com.shr.centralized.inspect.restful.service;

import com.shr.centralized.inspect.restful.model.ResultItemEntity;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author ：206612
 * @date ：Created in 2021/2/22 16:03
 * @description：Test
 */
public class Test {
    public static void main(String[] args) throws Exception
    {
        List<ResultItemEntity> list = new ArrayList<>();

        ResultItemEntity r6 = new ResultItemEntity();
        r6.setBayName("bay2");
        r6.setMainDeviceName("mainDevice1");
        r6.setComponentName("component1");
        r6.setDeviceName("device1");
        r6.setTaskResult("result1");
        list.add(r6);

        ResultItemEntity r8 = new ResultItemEntity();
        r8.setBayName("bay3");
        r8.setMainDeviceName("mainDevice1");
        r8.setComponentName("component1");
        r8.setDeviceName("device1");
        r8.setTaskResult("result1");
        list.add(r8);

        ResultItemEntity r7 = new ResultItemEntity();
        r7.setBayName("bay2");
        r7.setMainDeviceName("mainDevice1");
        r7.setComponentName("component2");
        r7.setDeviceName("device1");
        r7.setTaskResult("result1");
        list.add(r7);


        ResultItemEntity r5 = new ResultItemEntity();
        r5.setBayName("bay1");
        r5.setMainDeviceName("mainDevice2");
        r5.setComponentName("component3");
        r5.setDeviceName("device4");
        r5.setTaskResult("result5");
        list.add(r5);

        ResultItemEntity r1 = new ResultItemEntity();
        r1.setBayName("bay1");
        r1.setMainDeviceName("mainDevice1");
        r1.setComponentName("component1");
        r1.setDeviceName("device1");
        r1.setTaskResult("result1");
        list.add(r1);

        ResultItemEntity r2 = new ResultItemEntity();
        r2.setBayName("bay1");
        r2.setMainDeviceName("mainDevice2");
        r2.setComponentName("component2");
        r2.setDeviceName("device2");
        r2.setTaskResult("result2");
        list.add(r2);


        ResultItemEntity r4 = new ResultItemEntity();
        r4.setBayName("bay1");
        r4.setMainDeviceName("mainDevice2");
        r4.setComponentName("component3");
        r4.setDeviceName("device4");
        r4.setTaskResult("result4");
        list.add(r4);

        ResultItemEntity r3 = new ResultItemEntity();
        r3.setBayName("bay1");
        r3.setMainDeviceName("mainDevice2");
        r3.setComponentName("component3");
        r3.setDeviceName("device3");
        r3.setTaskResult("result3");
        list.add(r3);

        sortAndSetIndex(list);
        System.out.println(list);


    }

    private static void sortAndSetIndex(List<ResultItemEntity> itemEntities)
    {

        if (CollectionUtils.isEmpty(itemEntities) || itemEntities.size() <= 1) {
            return;
        }
        itemEntities.sort(Comparator.comparing(ResultItemEntity::getBayName).reversed().
                thenComparing(Comparator.comparing(ResultItemEntity::getMainDeviceName).reversed()).
                thenComparing(Comparator.comparing(ResultItemEntity::getComponentName).reversed()));
        for (int i = 1; i < itemEntities.size(); i++) {
            ResultItemEntity beforeItem = itemEntities.get(i - 1);
            ResultItemEntity currentItem = itemEntities.get(i);
            if (beforeItem.getBayName().equals(currentItem.getBayName())
                    && beforeItem.getMainDeviceName().equals(currentItem.getMainDeviceName())
                    && beforeItem.getComponentName().equals(currentItem.getComponentName())) {
                if (beforeItem.getIndex() < 3) {
                    beforeItem.setIndex(3);
                    beforeItem.setStart(2);
                }
                currentItem.setIndex(3);
            }
            else if (beforeItem.getBayName().equals(currentItem.getBayName())
                    && beforeItem.getMainDeviceName().equals(currentItem.getMainDeviceName())) {
                if (beforeItem.getIndex() < 2) {
                    beforeItem.setIndex(2);
                    beforeItem.setStart(2);
                }
                currentItem.setIndex(2);

            }
            else if (beforeItem.getBayName().equals(currentItem.getBayName())) {
                if (beforeItem.getIndex() < 1) {
                    beforeItem.setIndex(1);
                    beforeItem.setStart(2);
                }
                currentItem.setIndex(1);
            }
            else {
                currentItem.setIndex(0);
            }
        }
    }
}
