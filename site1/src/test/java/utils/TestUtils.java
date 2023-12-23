package utils;

import com.mysite.site1.models.Comment;
import com.mysite.site1.models.SingleContent;
import com.mysite.site1.models.User;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;

public class TestUtils {


    private static final User user = mock();
    private static final long id = 2;
    private static final List<Comment> commentList = mock();
    public static final SingleContent SINGLE_CONTENT = new SingleContent(
            id,
            "sample_title",
            "description",
            "url",
            user,
            300,
            233,
            commentList
    );

    public static final List<SingleContent> CONTENTS = new ArrayList<>(List.of(SINGLE_CONTENT));


}
