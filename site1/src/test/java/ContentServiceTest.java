import com.google.api.gax.rpc.ApiException;
import com.mysite.site1.error.ContentNotReturnedException;
import com.mysite.site1.models.Comment;
import com.mysite.site1.models.SingleContent;
import com.mysite.site1.models.User;
import com.mysite.site1.repository.ContentRepository;
import com.mysite.site1.services.impl.ContentServiceImpl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;
import static utils.TestUtils.CONTENTS;
import static utils.TestUtils.SINGLE_CONTENT;

@ExtendWith(MockitoExtension.class)
public class ContentServiceTest {
    @InjectMocks private ContentServiceImpl contentService;
    @Mock private ContentRepository contentRepository;
    private List<SingleContent> singleContents = mock();
    @Test
    void getContentsReturns200(){
        doReturn(CONTENTS).when(contentRepository).findAll();
        List<SingleContent> singleContentsTest = new ArrayList<>();
        try{
             singleContentsTest = contentService.getContents();
        }
        catch (ContentNotReturnedException e) {
            e.getMessage();
        }

        Assertions.assertEquals(CONTENTS, singleContentsTest);

    }

    @Test
    void getContentsThrowsExeption() throws ContentNotReturnedException{
        doReturn(singleContents).when(contentRepository).findAll();
        Assertions.assertThrows(ContentNotReturnedException.class, () -> contentService.getContents());

    }

}
