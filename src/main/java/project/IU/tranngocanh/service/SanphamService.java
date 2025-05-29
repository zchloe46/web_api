package project.IU.tranngocanh.service;

import project.IU.tranngocanh.entity.Sanpham;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.IU.tranngocanh.repository.SanphamRepository;

import java.util.List;

@Service
public class SanphamService {

    @Autowired
    private SanphamRepository spRepo;

    public List<Sanpham> getAll() {
        return spRepo.findAll();
    }

    public Sanpham createSanpham(Sanpham sanpham) {
        Sanpham sp = new Sanpham();
        sp.setTenSanPham(sanpham.getTenSanPham());
        sp.setGia(sanpham.getGia());
        sp.setHinhAnh(sanpham.getHinhAnh());
        sp.setNamSanXuat(sanpham.getNamSanXuat());
        sp.setHangSanXuat(sanpham.getHangSanXuat());
        return spRepo.save(sp);
    }

    public Sanpham updateSanpham(String id, Sanpham sanpham) {
        // lay sanpham theo id
        Sanpham sp = spRepo.findById(id).get();

        if(sp == null) {
            System.out.println("khong tim thay san pham");
            return null;
        }

        // cap nhat thong tin san pham
        sp.setTenSanPham(sanpham.getTenSanPham());
        sp.setGia(sanpham.getGia());
        sp.setHinhAnh(sanpham.getHinhAnh());
        sp.setNamSanXuat(sanpham.getNamSanXuat());
        sp.setHangSanXuat(sanpham.getHangSanXuat());

        return spRepo.save(sp);
    }
    // viet phuong thuc xoa san pham
    public Sanpham deleteSanpham(String id) {
        Sanpham sanpham = spRepo.findById(id).get();

        if(sanpham == null) {
            System.out.println("khong tim thay san pham");
        } else {
            spRepo.delete(sanpham);
            System.out.println("da xoa san pham");
        }
        return sanpham;
    }
}
