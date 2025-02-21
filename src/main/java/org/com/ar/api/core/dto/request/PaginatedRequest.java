package org.com.ar.api.core.dto.request;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PaginatedRequest {

    @Parameter(description = "Page number")
    @Schema(defaultValue = "0")
    private int page = 0;                 // Página actual (por defecto: 0)

    @Parameter(description = "Size of page")
    @Schema(defaultValue = "10")
    private int size = 10;                // Tamaño de página (por defecto: 10)

    @Parameter(description = "Field to sort by",hidden=true)
    @Schema(defaultValue = "id",hidden=true)
    private String sortBy = "id";         // Campo para ordenar (por defecto: id)

    
    @Parameter(description = "Sort direction",hidden=true)
    @Schema(defaultValue = "asc",hidden=true)
    private String sortDirection = "asc"; // Dirección del orden (por defecto: ascendente)




    // Método que construye el objeto PageRequest
    public PageRequest toPageRequest() {
        Sort sort = sortDirection.equalsIgnoreCase("asc") ?
                    Sort.by(sortBy).ascending() :
                    Sort.by(sortBy).descending();
        return PageRequest.of(page, size, sort);
    }
}
