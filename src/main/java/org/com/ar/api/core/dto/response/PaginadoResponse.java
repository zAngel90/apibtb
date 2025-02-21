package org.com.ar.api.core.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.data.domain.Page;
import java.util.List;

@Data
public class PaginadoResponse<T> {
    
    @Schema(description = "Lista de elementos")
    private List<T> content;
    
    @Schema(description = "Número total de elementos", example = "100")
    private long totalElements;
    
    @Schema(description = "Número total de páginas", example = "10")
    private int totalPages;
    
    @Schema(description = "Número de página actual (0-based)", example = "0")
    private int pageNumber;
    
    @Schema(description = "Tamaño de página", example = "10")
    private int pageSize;
    
    public PaginadoResponse(Page<T> page) {
        this.content = page.getContent();
        this.totalElements = page.getTotalElements();
        this.totalPages = page.getTotalPages();
        this.pageNumber = page.getNumber();
        this.pageSize = page.getSize();
    }
}
