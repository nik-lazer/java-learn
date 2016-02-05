package lan.training.jdk8features.stream;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by nik-lazer on 2/5/2016.
 */
public class NestedTest {
    private MainModel cMainModel;
    private SubModel cSubModel;
    private SubSubModel cSubSubModel;
    List<MainModel> mainModelList;
    private NestedSample nestedSample = new NestedSample();

    @Before
    public void init() {
        cMainModel = new MainModel("mainfield1", 5, Arrays.asList());
        cSubModel = new SubModel("subfield1", Arrays.asList());
        cSubSubModel = new SubSubModel("subsubfield1");
        mainModelList = Arrays.asList(
                new MainModel("mainfield1", 10, Arrays.asList(
                        new SubModel("subfield1", Arrays.asList(
                                new SubSubModel("subsubfield1"),
                                new SubSubModel("subsubfield2"),
                                new SubSubModel("subsubfield3")
                        )),
                        new SubModel("subfield2", Arrays.asList(
                                new SubSubModel("subsubfield1"),
                                new SubSubModel("subsubfield2")
                        ))
                )),
                new MainModel("mainfield1", 21, Arrays.asList(
                        new SubModel("subfield3", Arrays.asList(
                                new SubSubModel("subsubfield1"),
                                new SubSubModel("subsubfield2"),
                                new SubSubModel("subsubfield3")
                        )),
                        new SubModel("subfield4", Arrays.asList(
                                new SubSubModel("subsubfield1"),
                                new SubSubModel("subsubfield2")
                        ))
                )),
                new MainModel("mainfield2", 15, Arrays.asList(
                        new SubModel("subfield1", Arrays.asList(
                                new SubSubModel("subsubfield1"),
                                new SubSubModel("subsubfield2")
                        )),
                        new SubModel("subfield2", Arrays.asList(
                                new SubSubModel("subsubfield1"),
                                new SubSubModel("subsubfield2"),
                                new SubSubModel("subsubfield3")
                        ))
                )),
                new MainModel("mainfield1", 12, Arrays.asList(
                        new SubModel("subfield1", Arrays.asList(
                                new SubSubModel("subsubfield2"),
                                new SubSubModel("subsubfield3"),
                                new SubSubModel("subsubfield1")
                        )),
                        new SubModel("subfield2", Arrays.asList(
                                new SubSubModel("subsubfield1"),
                                new SubSubModel("subsubfield3")
                        ))
                )),
                new MainModel("mainfield1", 19, Arrays.asList(
                        new SubModel("subfield1", Arrays.asList(
                                new SubSubModel("subsubfield2"),
                                new SubSubModel("subsubfield3"),
                                new SubSubModel("subsubfield4")
                        )),
                        new SubModel("subfield2", Arrays.asList(
                                new SubSubModel("subsubfield1"),
                                new SubSubModel("subsubfield3")
                        ))
                ))
        );

    }

    @Test
    public void nestedTest() {
        String loopsResult = nestedSample.getByLoops(mainModelList, cMainModel, cSubModel, cSubSubModel);
        String strightStreamsResult = nestedSample.getByStrightStreams(mainModelList, cMainModel, cSubModel, cSubSubModel);
        String simplerStreamsResult = nestedSample.getBySimplerStreams(mainModelList, cMainModel, cSubModel, cSubSubModel);
        assertEquals("mainfield1[10]mainfield1[12]", loopsResult);
        assertEquals("mainfield1[10]mainfield1[12]", strightStreamsResult);
        assertEquals("mainfield1[10]mainfield1[12]", simplerStreamsResult);
    }
}
