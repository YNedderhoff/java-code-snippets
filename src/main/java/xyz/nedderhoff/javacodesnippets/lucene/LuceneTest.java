package xyz.nedderhoff.javacodesnippets.lucene;

import java.io.IOException;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.LongPoint;
import org.apache.lucene.document.StoredField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.RAMDirectory;

public class LuceneTest {

    public static void main(String[] args) {
        Directory index = new RAMDirectory();
        StandardAnalyzer analyzer = new StandardAnalyzer();

        try {
            IndexWriter indexWriter = new IndexWriter(index, new IndexWriterConfig(analyzer));

            Document document1 = new Document();
            Document document2 = new Document();

            document1.add(new LongPoint("my_range_field", 10));
            document1.add(new StoredField("my_range_field", 10));
            document2.add(new LongPoint("my_range_field", 100));
            document2.add(new StoredField("my_range_field", 100));

            document1.add(new TextField("my_text_field", "test content 1", Field.Store.YES));
            document1.add(new TextField("my_text_field", "test content 2", Field.Store.YES));

            indexWriter.addDocument(document1);
            indexWriter.addDocument(document2);

            QueryParser parser = new QueryParser("text", analyzer);
            parser.setAllowLeadingWildcard(true);
            IndexSearcher indexSearcher = new IndexSearcher(DirectoryReader.open(index));

            String luceneQuery = "+my_text_field:test my_range_field:[1 TO 15]";
            Query query = parser.parse(luceneQuery);
            System.out.println("Query" + query.toString());
            System.out.println(indexSearcher.search(query, 10).totalHits.value);
        } catch (IOException e) {

        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
}
