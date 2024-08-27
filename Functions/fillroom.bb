Function fillroom%(arg0.rooms)
    Local local0.doors
    Local local1.doors
    Local local2.securitycams
    Local local3.decals
    Local local4.rooms
    Local local5%
    Local local6.items
    Local local7%
    Local local8%
    Local local9%
    Local local10%
    Local local11.objects
    Local local12%
    Local local14.forest
    Local local15.emitters
    Local local16%
    Local local17%
    Local local18%
    Local local20#
    Local local21#
    Local local23%
    Local local25.items
    Local local26.waypoints
    Local local27.waypoints
    Local local28#
    Local local29#
    Local local30#
    Local local31%
    Local local33#
    Local local34#
    Local local35#
    Local local36#
    Local local40$
    Local local41$
    Local local42%
    Local local45%
    Local local47#
    Local local48%
    Local local49%
    Local local51%
    Local local52#
    Local local54%
    Local local55%
    Local local56%
    Local local58#
    Local local59%
    Local local63#
    Local local64#
    Local local67.lighttemplates
    Local local68%
    Local local69.tempscreens
    Local local70.tempwaypoints
    local11 = (First objects)
    Select arg0\Field7\Field10
        Case "room860"
            arg0\Field19[$02] = copyentity(local11\Field3[$08], arg0\Field2)
            positionentity(arg0\Field19[$02], (arg0\Field3 + (184.0 * roomscale)), arg0\Field4, arg0\Field5, $01)
            scaleentity(arg0\Field19[$02], (45.0 * roomscale), (45.0 * roomscale), (80.0 * roomscale), $01)
            arg0\Field19[$03] = copyentity(local11\Field3[$09], arg0\Field2)
            positionentity(arg0\Field19[$03], (arg0\Field3 + (112.0 * roomscale)), arg0\Field4, (arg0\Field5 + 0.05), $01)
            entitytype(arg0\Field19[$03], $01, $00)
            scaleentity(arg0\Field19[$03], (46.0 * roomscale), (45.0 * roomscale), (46.0 * roomscale), $01)
            arg0\Field19[$04] = copyentity(arg0\Field19[$03], $00)
            positionentity(arg0\Field19[$04], (arg0\Field3 + (256.0 * roomscale)), arg0\Field4, (arg0\Field5 - 0.05), $00)
            rotateentity(arg0\Field19[$04], 0.0, 180.0, 0.0, $00)
            scaleentity(arg0\Field19[$04], (46.0 * roomscale), (45.0 * roomscale), (46.0 * roomscale), $00)
            entityparent(arg0\Field19[$04], arg0\Field2, $01)
            local0 = createdoor(arg0\Field0, (arg0\Field3 + (928.0 * roomscale)), arg0\Field4, (arg0\Field5 + (640.0 * roomscale)), 0.0, arg0, $00, $00, $00, "ABCD", $00)
            local0 = createdoor(arg0\Field0, (arg0\Field3 + (928.0 * roomscale)), arg0\Field4, (arg0\Field5 - (640.0 * roomscale)), 0.0, arg0, $01, $00, $00, "ABCD", $00)
            local0\Field21 = $00
            local0 = createdoor(arg0\Field0, (arg0\Field3 + (416.0 * roomscale)), arg0\Field4, (arg0\Field5 - (640.0 * roomscale)), 0.0, arg0, $00, $00, $01, "", $00)
            local0 = createdoor(arg0\Field0, (arg0\Field3 + (416.0 * roomscale)), arg0\Field4, (arg0\Field5 + (640.0 * roomscale)), 0.0, arg0, $00, $00, $01, "", $00)
            If (i_zone\Field1 = $00) Then
                local14 = (New forest)
                arg0\Field11 = local14
                genforestgrid(local14)
                placeforest(local14, arg0\Field3, (arg0\Field4 + 30.0), arg0\Field5, arg0)
            EndIf
            local6 = createitem("Document SCP-860-1", "paper", (arg0\Field3 + (672.0 * roomscale)), (arg0\Field4 + (176.0 * roomscale)), (arg0\Field5 + (335.0 * roomscale)), $00, $00, $00, 1.0, $00)
            entityparent(local6\Field1, arg0\Field2, $01)
            rotateentity(local6\Field1, 0.0, (Float (arg0\Field6 + $0A)), 0.0, $00)
            local6 = createitem("Document SCP-860", "paper", (arg0\Field3 + (1152.0 * roomscale)), (arg0\Field4 + (176.0 * roomscale)), (arg0\Field5 - (384.0 * roomscale)), $00, $00, $00, 1.0, $00)
            entityparent(local6\Field1, arg0\Field2, $01)
            rotateentity(local6\Field1, 0.0, (Float (arg0\Field6 + $AA)), 0.0, $00)
        Case "lockroom"
            local0 = createdoor(arg0\Field0, (arg0\Field3 - (736.0 * roomscale)), arg0\Field4, (arg0\Field5 - (104.0 * roomscale)), 0.0, arg0, $01, $00, $00, "", $00)
            local0\Field10 = $15E
            local0\Field21 = $00
            local0\Field5 = $00
            entityparent(local0\Field3[$00], $00, $01)
            positionentity(local0\Field3[$00], (arg0\Field3 - (288.0 * roomscale)), (arg0\Field4 + 0.7), (arg0\Field5 - (634.0 * roomscale)), $00)
            entityparent(local0\Field3[$00], arg0\Field2, $01)
            freeentity(local0\Field3[$01])
            local0\Field3[$01] = $00
            local1 = createdoor(arg0\Field0, (arg0\Field3 + (104.0 * roomscale)), arg0\Field4, (arg0\Field5 + (736.0 * roomscale)), 270.0, arg0, $01, $00, $00, "", $00)
            local1\Field10 = $15E
            local1\Field21 = $00
            local1\Field5 = $00
            entityparent(local1\Field3[$00], $00, $01)
            positionentity(local1\Field3[$00], (arg0\Field3 + (634.0 * roomscale)), (arg0\Field4 + 0.7), (arg0\Field5 + (288.0 * roomscale)), $00)
            rotateentity(local1\Field3[$00], 0.0, 90.0, 0.0, $00)
            entityparent(local1\Field3[$00], arg0\Field2, $01)
            freeentity(local1\Field3[$01])
            local1\Field3[$01] = $00
            local0\Field22 = local1
            local1\Field22 = local0
            local2 = createsecuritycam((arg0\Field3 - (688.0 * roomscale)), (arg0\Field4 + (384.0 * roomscale)), (arg0\Field5 + (688.0 * roomscale)), arg0, $01)
            local2\Field11 = 225.0
            local2\Field12 = 45.0
            local2\Field9 = $01
            entitytexture(local2\Field4, screentexs[local2\Field9], $00, $00)
            turnentity(local2\Field3, 40.0, 0.0, 0.0, $00)
            entityparent(local2\Field0, arg0\Field2, $01)
            positionentity(local2\Field4, (arg0\Field3 + (668.0 * roomscale)), (arg0\Field4 + 1.1), (arg0\Field5 - (96.0 * roomscale)), $00)
            turnentity(local2\Field4, 0.0, 90.0, 0.0, $00)
            entityparent(local2\Field4, arg0\Field2, $01)
            local2 = createsecuritycam((arg0\Field3 - (112.0 * roomscale)), (arg0\Field4 + (384.0 * roomscale)), (arg0\Field5 + (112.0 * roomscale)), arg0, $01)
            local2\Field11 = 45.0
            local2\Field12 = 45.0
            local2\Field9 = $01
            entitytexture(local2\Field4, screentexs[local2\Field9], $00, $00)
            turnentity(local2\Field3, 40.0, 0.0, 0.0, $00)
            entityparent(local2\Field0, arg0\Field2, $01)
            positionentity(local2\Field4, (arg0\Field3 + (96.0 * roomscale)), 1.1, (arg0\Field5 - (668.0 * roomscale)), $00)
            entityparent(local2\Field4, arg0\Field2, $01)
            local15 = createemitter((arg0\Field3 - (175.0 * roomscale)), (370.0 * roomscale), (arg0\Field5 + (656.0 * roomscale)), $00)
            turnentity(local15\Field0, 90.0, 0.0, 0.0, $00)
            entityparent(local15\Field0, arg0\Field2, $01)
            local15\Field10 = 20.0
            local15\Field9 = 0.05
            local15\Field11 = 0.007
            local15\Field12 = -0.006
            local15\Field4 = -0.24
            local15 = createemitter((arg0\Field3 - (655.0 * roomscale)), (370.0 * roomscale), (arg0\Field5 + (240.0 * roomscale)), $00)
            turnentity(local15\Field0, 90.0, 0.0, 0.0, $00)
            entityparent(local15\Field0, arg0\Field2, $01)
            local15\Field10 = 20.0
            local15\Field9 = 0.05
            local15\Field11 = 0.007
            local15\Field12 = -0.006
            local15\Field4 = -0.24
        Case "lockroom2"
            For local7 = $00 To $05 Step $01
                local3 = createdecal(rand($02, $03), (arg0\Field3 + (rnd(-392.0, 520.0) * roomscale)), ((3.0 * roomscale) + rnd(0.0, 0.001)), (arg0\Field5 + (rnd(-392.0, 520.0) * roomscale)), 90.0, rnd(360.0, 0.0), 0.0)
                local3\Field2 = rnd(0.3, 0.6)
                scalesprite(local3\Field0, local3\Field2, local3\Field2)
                createdecal(rand($0F, $10), (arg0\Field3 + (rnd(-392.0, 520.0) * roomscale)), ((3.0 * roomscale) + rnd(0.0, 0.001)), (arg0\Field5 + (rnd(-392.0, 520.0) * roomscale)), 90.0, rnd(360.0, 0.0), 0.0)
                local3\Field2 = rnd(0.1, 0.6)
                scalesprite(local3\Field0, local3\Field2, local3\Field2)
                createdecal(rand($0F, $10), (arg0\Field3 + rnd(-0.5, 0.5)), ((3.0 * roomscale) + rnd(0.0, 0.001)), (arg0\Field5 + rnd(-0.5, 0.5)), 90.0, rnd(360.0, 0.0), 0.0)
                local3\Field2 = rnd(0.1, 0.6)
                scalesprite(local3\Field0, local3\Field2, local3\Field2)
            Next
            local2 = createsecuritycam((arg0\Field3 + (512.0 * roomscale)), (arg0\Field4 + (384.0 * roomscale)), (arg0\Field5 + (384.0 * roomscale)), arg0, $01)
            local2\Field11 = 135.0
            local2\Field12 = 45.0
            turnentity(local2\Field3, 40.0, 0.0, 0.0, $00)
            entityparent(local2\Field0, arg0\Field2, $01)
            positionentity(local2\Field4, (arg0\Field3 + (668.0 * roomscale)), (arg0\Field4 + 1.1), (arg0\Field5 - (96.0 * roomscale)), $00)
            turnentity(local2\Field4, 0.0, 90.0, 0.0, $00)
            entityparent(local2\Field4, arg0\Field2, $01)
            local2 = createsecuritycam((arg0\Field3 - (384.0 * roomscale)), (arg0\Field4 + (384.0 * roomscale)), (arg0\Field5 - (512.0 * roomscale)), arg0, $01)
            local2\Field11 = 315.0
            local2\Field12 = 45.0
            turnentity(local2\Field3, 40.0, 0.0, 0.0, $00)
            entityparent(local2\Field0, arg0\Field2, $01)
            positionentity(local2\Field4, (arg0\Field3 + (96.0 * roomscale)), (arg0\Field4 + 1.1), (arg0\Field5 - (668.0 * roomscale)), $00)
            entityparent(local2\Field4, arg0\Field2, $01)
        Case "gatea"
            arg0\Field21[$02] = createdoor(arg0\Field0, (arg0\Field3 - (4064.0 * roomscale)), (arg0\Field4 - (1280.0 * roomscale)), (arg0\Field5 + (3952.0 * roomscale)), 0.0, arg0, $00, $00, $00, "", $00)
            arg0\Field21[$02]\Field21 = $00
            arg0\Field21[$02]\Field5 = $00
            local1 = createdoor(arg0\Field0, arg0\Field3, arg0\Field4, (arg0\Field5 - (1024.0 * roomscale)), 0.0, arg0, $00, $00, $00, "", $00)
            local1\Field21 = $00
            local1\Field5 = $00
            local1\Field4 = $01
            freeentity(local1\Field3[$00])
            local1\Field3[$00] = $00
            local1 = createdoor(arg0\Field0, (arg0\Field3 - (1440.0 * roomscale)), (arg0\Field4 - (480.0 * roomscale)), (arg0\Field5 + (2328.0 * roomscale)), 0.0, arg0, $00, $00, $02, "", $00)
            If (i_end\Field2 = "A2") Then
                local1\Field21 = $00
                local1\Field5 = $01
                local1\Field4 = $01
            Else
                local1\Field21 = $00
                local1\Field5 = $00
                local1\Field4 = $00
            EndIf
            positionentity(local1\Field3[$00], (arg0\Field3 - (1320.0 * roomscale)), entityy(local1\Field3[$00], $01), (arg0\Field5 + (2294.0 * roomscale)), $01)
            positionentity(local1\Field3[$01], (arg0\Field3 - (1590.0 * roomscale)), entityy(local1\Field3[$00], $01), (arg0\Field5 + (2484.0 * roomscale)), $01)
            rotateentity(local1\Field3[$01], 0.0, 90.0, 0.0, $01)
            local1 = createdoor(arg0\Field0, (arg0\Field3 - (1440.0 * roomscale)), (arg0\Field4 - (480.0 * roomscale)), (arg0\Field5 + (4352.0 * roomscale)), 0.0, arg0, $00, $00, $02, "", $00)
            If (i_end\Field2 = "A2") Then
                local1\Field21 = $00
                local1\Field5 = $01
                local1\Field4 = $01
            Else
                local1\Field21 = $00
                local1\Field5 = $00
                local1\Field4 = $00
            EndIf
            positionentity(local1\Field3[$00], (arg0\Field3 - (1320.0 * roomscale)), entityy(local1\Field3[$00], $01), (arg0\Field5 + (4378.0 * roomscale)), $01)
            rotateentity(local1\Field3[$00], 0.0, 180.0, 0.0, $01)
            positionentity(local1\Field3[$01], (arg0\Field3 - (1590.0 * roomscale)), entityy(local1\Field3[$00], $01), (arg0\Field5 + (4232.0 * roomscale)), $01)
            rotateentity(local1\Field3[$01], 0.0, 90.0, 0.0, $01)
            For local4 = Each rooms
                If (local4\Field7\Field10 = "gateb") Then
                    arg0\Field19[$01] = local4\Field19[$01]
                    arg0\Field19[$02] = local4\Field19[$02]
                ElseIf (local4\Field7\Field10 = "gateaentrance") Then
                    arg0\Field21[$01] = createdoor($00, (arg0\Field3 + (1544.0 * roomscale)), arg0\Field4, (arg0\Field5 - (64.0 * roomscale)), 90.0, arg0, $00, $03, $00, "", $00)
                    arg0\Field21[$01]\Field21 = $00
                    arg0\Field21[$01]\Field5 = $00
                    positionentity(arg0\Field21[$01]\Field3[$00], (arg0\Field3 + (1578.0 * roomscale)), entityy(arg0\Field21[$01]\Field3[$00], $01), (arg0\Field5 + (80.0 * roomscale)), $01)
                    positionentity(arg0\Field21[$01]\Field3[$01], (arg0\Field3 + (1462.0 * roomscale)), entityy(arg0\Field21[$01]\Field3[$01], $01), (arg0\Field5 - (208.0 * roomscale)), $01)
                    local4\Field19[$01] = createpivot($00)
                    positionentity(local4\Field19[$01], (arg0\Field3 + (1848.0 * roomscale)), (arg0\Field4 + (240.0 * roomscale)), (arg0\Field5 - (64.0 * roomscale)), $00)
                    entityparent(local4\Field19[$01], arg0\Field2, $01)
                EndIf
            Next
            arg0\Field19[$03] = createpivot($00)
            positionentity(arg0\Field19[$03], (arg0\Field3 + (1216.0 * roomscale)), arg0\Field4, (arg0\Field5 + (2112.0 * roomscale)), $00)
            entityparent(arg0\Field19[$03], arg0\Field2, $01)
            arg0\Field19[$04] = createpivot($00)
            positionentity(arg0\Field19[$04], arg0\Field3, (arg0\Field4 + (96.0 * roomscale)), (arg0\Field5 + (6400.0 * roomscale)), $00)
            entityparent(arg0\Field19[$04], arg0\Field2, $01)
            arg0\Field19[$05] = createpivot($00)
            positionentity(arg0\Field19[$05], (arg0\Field3 + (1784.0 * roomscale)), (arg0\Field4 + (2124.0 * roomscale)), (arg0\Field5 + (4512.0 * roomscale)), $00)
            entityparent(arg0\Field19[$05], arg0\Field2, $01)
            arg0\Field19[$06] = createpivot($00)
            positionentity(arg0\Field19[$06], (arg0\Field3 - (5048.0 * roomscale)), (arg0\Field4 + (1912.0 * roomscale)), (arg0\Field5 + (4656.0 * roomscale)), $00)
            entityparent(arg0\Field19[$06], arg0\Field2, $01)
            arg0\Field19[$07] = createpivot($00)
            positionentity(arg0\Field19[$07], (arg0\Field3 + (1824.0 * roomscale)), (arg0\Field4 + (224.0 * roomscale)), (arg0\Field5 + (7056.0 * roomscale)), $00)
            entityparent(arg0\Field19[$07], arg0\Field2, $01)
            arg0\Field19[$08] = createpivot($00)
            positionentity(arg0\Field19[$08], (arg0\Field3 - (1824.0 * roomscale)), (arg0\Field4 + (224.0 * roomscale)), (arg0\Field5 + (7056.0 * roomscale)), $00)
            entityparent(arg0\Field19[$08], arg0\Field2, $01)
            arg0\Field19[$09] = createpivot($00)
            positionentity(arg0\Field19[$09], (arg0\Field3 + (2624.0 * roomscale)), (arg0\Field4 + (992.0 * roomscale)), (arg0\Field5 + (6157.0 * roomscale)), $00)
            entityparent(arg0\Field19[$09], arg0\Field2, $01)
            If (arg0\Field19[$0D] = $00) Then
                arg0\Field19[$0D] = loadmesh_strict(scpmodding_processfilepath("GFX\map\gateawall1.b3d"), arg0\Field2)
            EndIf
            positionentity(arg0\Field19[$0D], (arg0\Field3 - (4308.0 * roomscale)), (arg0\Field4 - (1045.0 * roomscale)), (arg0\Field5 + (544.0 * roomscale)), $01)
            entitycolor(arg0\Field19[$0D], 25.0, 25.0, 25.0)
            entitytype(arg0\Field19[$0D], $01, $00)
            If (arg0\Field19[$0E] = $00) Then
                arg0\Field19[$0E] = loadmesh_strict(scpmodding_processfilepath("GFX\map\gateawall2.b3d"), arg0\Field2)
            EndIf
            positionentity(arg0\Field19[$0E], (arg0\Field3 - (3820.0 * roomscale)), (arg0\Field4 - (1045.0 * roomscale)), (arg0\Field5 + (544.0 * roomscale)), $01)
            entitycolor(arg0\Field19[$0E], 25.0, 25.0, 25.0)
            entitytype(arg0\Field19[$0E], $01, $00)
            arg0\Field19[$0F] = createpivot($00)
            positionentity(arg0\Field19[$0F], (arg0\Field3 - (3568.0 * roomscale)), (arg0\Field4 - (1089.0 * roomscale)), (arg0\Field5 + (4944.0 * roomscale)), $00)
            entityparent(arg0\Field19[$0F], arg0\Field2, $01)
            If (arg0\Field19[$10] = $00) Then
                arg0\Field19[$10] = loadmesh_strict(scpmodding_processfilepath("GFX\map\gatea_hitbox1.b3d"), arg0\Field2)
            EndIf
            entitypickmode(arg0\Field19[$10], $02, $01)
            entitytype(arg0\Field19[$10], $01, $00)
            entityalpha(arg0\Field19[$10], 0.0)
            arg0\Field19[$11] = createpivot($00)
            positionentity(arg0\Field19[$11], (arg0\Field3 - (4064.0 * roomscale)), (arg0\Field4 - (1248.0 * roomscale)), (arg0\Field5 - (1696.0 * roomscale)), $00)
            entityparent(arg0\Field19[$11], arg0\Field2, $01)
            arg0\Field19[$12] = createpivot($00)
            positionentity(arg0\Field19[$12], (arg0\Field3 - (3968.0 * roomscale)), (arg0\Field4 - (1248.0 * roomscale)), (arg0\Field5 - (1920.0 * roomscale)), $00)
            entityparent(arg0\Field19[$12], arg0\Field2, $01)
            arg0\Field19[$13] = createpivot($00)
            positionentity(arg0\Field19[$13], (arg0\Field3 - (4160.0 * roomscale)), (arg0\Field4 - (1248.0 * roomscale)), (arg0\Field5 - (1920.0 * roomscale)), $00)
            entityparent(arg0\Field19[$13], arg0\Field2, $01)
            arg0\Field19[$14] = createpivot($00)
            positionentity(arg0\Field19[$14], (arg0\Field3 - (4064.0 * roomscale)), (arg0\Field4 - (1248.0 * roomscale)), (arg0\Field5 - (2112.0 * roomscale)), $00)
            entityparent(arg0\Field19[$14], arg0\Field2, $01)
        Case "gateaentrance"
            arg0\Field21[$00] = createdoor($00, (arg0\Field3 + (736.0 * roomscale)), arg0\Field4, (arg0\Field5 + (512.0 * roomscale)), 90.0, arg0, $01, $03, $00, "", $00)
            arg0\Field21[$00]\Field21 = $00
            arg0\Field21[$00]\Field5 = $01
            positionentity(arg0\Field21[$00]\Field3[$01], (entityx(arg0\Field21[$00]\Field3[$01], $01) - 0.061), entityy(arg0\Field21[$00]\Field3[$01], $01), entityz(arg0\Field21[$00]\Field3[$01], $01), $01)
            positionentity(arg0\Field21[$00]\Field3[$00], (entityx(arg0\Field21[$00]\Field3[$00], $01) + 0.061), entityy(arg0\Field21[$00]\Field3[$00], $01), entityz(arg0\Field21[$00]\Field3[$00], $01), $01)
            arg0\Field21[$01] = createdoor(arg0\Field0, arg0\Field3, 0.0, (arg0\Field5 - (360.0 * roomscale)), 0.0, arg0, $00, $01, $07, "", $00)
            arg0\Field21[$01]\Field9 = $01
            arg0\Field21[$01]\Field21 = $00
            arg0\Field21[$01]\Field5 = $00
            positionentity(arg0\Field21[$01]\Field3[$01], (arg0\Field3 + (422.0 * roomscale)), entityy(arg0\Field21[$00]\Field3[$01], $01), (arg0\Field5 - (576.0 * roomscale)), $01)
            rotateentity(arg0\Field21[$01]\Field3[$01], 0.0, (Float (arg0\Field6 - $5A)), 0.0, $01)
            positionentity(arg0\Field21[$01]\Field3[$00], (arg0\Field3 - (522.0 * roomscale)), entityy(arg0\Field21[$01]\Field3[$00], $01), entityz(arg0\Field21[$01]\Field3[$00], $01), $01)
            rotateentity(arg0\Field21[$01]\Field3[$00], 0.0, (Float (arg0\Field6 - $E1)), 0.0, $01)
            arg0\Field19[$00] = createpivot($00)
            positionentity(arg0\Field19[$00], (arg0\Field3 + (1048.0 * roomscale)), arg0\Field4, (arg0\Field5 + (512.0 * roomscale)), $00)
            entityparent(arg0\Field19[$00], arg0\Field2, $01)
        Case "gateb"
            arg0\Field19[$00] = createpivot($00)
            positionentity(arg0\Field19[$00], (arg0\Field3 + (4356.0 * roomscale)), (arg0\Field4 + (9767.0 * roomscale)), (arg0\Field5 + (2588.0 * roomscale)), $00)
            entityparent(arg0\Field19[$00], arg0\Field2, $01)
            arg0\Field21[$04] = createdoor(arg0\Field0, arg0\Field3, arg0\Field4, (arg0\Field5 - (320.0 * roomscale)), 0.0, arg0, $00, $01, $07, "", $00)
            arg0\Field21[$04]\Field9 = $01
            arg0\Field21[$04]\Field21 = $00
            arg0\Field21[$04]\Field5 = $00
            positionentity(arg0\Field21[$04]\Field3[$01], (arg0\Field3 + (358.0 * roomscale)), entityy(arg0\Field21[$04]\Field3[$01], $01), (arg0\Field5 - (528.0 * roomscale)), $01)
            rotateentity(arg0\Field21[$04]\Field3[$01], 0.0, (Float (arg0\Field6 - $5A)), 0.0, $01)
            positionentity(arg0\Field21[$04]\Field3[$00], entityx(arg0\Field21[$04]\Field3[$00], $01), entityy(arg0\Field21[$04]\Field3[$00], $01), (arg0\Field5 - (198.0 * roomscale)), $01)
            rotateentity(arg0\Field21[$04]\Field3[$00], 0.0, (Float (arg0\Field6 - $B4)), 0.0, $01)
            arg0\Field19[$03] = createpivot($00)
            positionentity(arg0\Field19[$03], (arg0\Field3 - (7680.0 * roomscale)), (arg0\Field4 + (10992.0 * roomscale)), (arg0\Field5 - (27048.0 * roomscale)), $00)
            entityparent(arg0\Field19[$03], arg0\Field2, $01)
            arg0\Field19[$04] = createpivot($00)
            positionentity(arg0\Field19[$04], (arg0\Field3 + (5203.36 * roomscale)), (arg0\Field4 + (12128.0 * roomscale)), (arg0\Field5 - (1739.19 * roomscale)), $00)
            entityparent(arg0\Field19[$04], arg0\Field2, $01)
            arg0\Field19[$05] = createpivot($00)
            positionentity(arg0\Field19[$05], (arg0\Field3 + (4363.02 * roomscale)), (arg0\Field4 + (10536.0 * roomscale)), (arg0\Field5 + (2766.16 * roomscale)), $00)
            entityparent(arg0\Field19[$05], arg0\Field2, $01)
            arg0\Field19[$06] = createpivot($00)
            positionentity(arg0\Field19[$06], (arg0\Field3 + (5192.0 * roomscale)), (arg0\Field4 + (12192.0 * roomscale)), (arg0\Field5 - (1760.0 * roomscale)), $00)
            entityparent(arg0\Field19[$06], arg0\Field2, $01)
            arg0\Field19[$07] = createpivot($00)
            positionentity(arg0\Field19[$07], (arg0\Field3 + (5192.0 * roomscale)), (arg0\Field4 + (12192.0 * roomscale)), (arg0\Field5 - (4352.0 * roomscale)), $00)
            entityparent(arg0\Field19[$07], arg0\Field2, $01)
            arg0\Field21[$00] = createdoor($00, (arg0\Field3 + (720.0 * roomscale)), arg0\Field4, (arg0\Field5 + (1432.0 * roomscale)), 0.0, arg0, $01, $03, $00, "", $00)
            arg0\Field21[$00]\Field21 = $00
            arg0\Field21[$00]\Field5 = $01
            positionentity(arg0\Field21[$00]\Field3[$00], entityx(arg0\Field21[$00]\Field3[$00], $01), entityy(arg0\Field21[$00]\Field3[$00], $01), (entityz(arg0\Field21[$00]\Field3[$00], $01) + 0.031), $01)
            positionentity(arg0\Field21[$00]\Field3[$01], entityx(arg0\Field21[$00]\Field3[$01], $01), entityy(arg0\Field21[$00]\Field3[$01], $01), (entityz(arg0\Field21[$00]\Field3[$01], $01) - 0.031), $01)
            arg0\Field21[$01] = createdoor($00, (arg0\Field3 - (5424.0 * roomscale)), (arg0\Field4 + (10784.0 * roomscale)), (arg0\Field5 - (1380.0 * roomscale)), 0.0, arg0, $00, $03, $00, "", $00)
            arg0\Field21[$01]\Field21 = $00
            arg0\Field21[$01]\Field5 = $00
            positionentity(arg0\Field21[$01]\Field3[$00], entityx(arg0\Field21[$01]\Field3[$00], $01), entityy(arg0\Field21[$01]\Field3[$00], $01), (entityz(arg0\Field21[$01]\Field3[$00], $01) + 0.031), $01)
            positionentity(arg0\Field21[$01]\Field3[$01], entityx(arg0\Field21[$01]\Field3[$01], $01), entityy(arg0\Field21[$01]\Field3[$01], $01), (entityz(arg0\Field21[$01]\Field3[$01], $01) - 0.031), $01)
            arg0\Field19[$08] = createpivot($00)
            positionentity(arg0\Field19[$08], (arg0\Field3 + (720.0 * roomscale)), arg0\Field4, (arg0\Field5 + (1744.0 * roomscale)), $00)
            entityparent(arg0\Field19[$08], arg0\Field2, $01)
            arg0\Field19[$09] = createpivot($00)
            positionentity(arg0\Field19[$09], (arg0\Field3 - (5424.0 * roomscale)), (arg0\Field4 + (10784.0 * roomscale)), (arg0\Field5 - (1068.0 * roomscale)), $00)
            entityparent(arg0\Field19[$09], arg0\Field2, $01)
            arg0\Field21[$02] = createdoor($00, (arg0\Field3 + (4352.0 * roomscale)), (arg0\Field4 + (10784.0 * roomscale)), (arg0\Field5 - (492.0 * roomscale)), 0.0, arg0, $00, $00, $00, "", $00)
            arg0\Field21[$02]\Field21 = $00
            arg0\Field21[$02]\Field5 = $00
            arg0\Field21[$03] = createdoor($00, (arg0\Field3 + (4352.0 * roomscale)), (arg0\Field4 + (10784.0 * roomscale)), (arg0\Field5 + (498.0 * roomscale)), 0.0, arg0, $00, $00, $00, "", $00)
            arg0\Field21[$03]\Field21 = $00
            arg0\Field21[$03]\Field5 = $00
            arg0\Field19[$0A] = createpivot($00)
            positionentity(arg0\Field19[$0A], (arg0\Field3 + (4352.0 * roomscale)), (arg0\Field4 + (10778.0 * roomscale)), (arg0\Field5 + (1344.0 * roomscale)), $00)
            entityparent(arg0\Field19[$0A], arg0\Field2, $01)
            arg0\Field19[$0B] = createpivot($00)
            positionentity(arg0\Field19[$0B], (arg0\Field3 + (2816.0 * roomscale)), (arg0\Field4 + (11024.0 * roomscale)), (arg0\Field5 - (2816.0 * roomscale)), $00)
            entityparent(arg0\Field19[$0B], arg0\Field2, $01)
            arg0\Field21[$05] = createdoor($00, (arg0\Field3 + (3248.0 * roomscale)), (arg0\Field4 + (9856.0 * roomscale)), (arg0\Field5 + (6400.0 * roomscale)), 0.0, arg0, $00, $00, $00, "ABCD", $00)
            arg0\Field21[$05]\Field21 = $00
            arg0\Field21[$05]\Field5 = $00
            freeentity(arg0\Field21[$05]\Field3[$01])
            arg0\Field21[$05]\Field3[$01] = $00
            local0 = createdoor($00, (arg0\Field3 + (3072.0 * roomscale)), (arg0\Field4 + (9856.0 * roomscale)), (arg0\Field5 + (5800.0 * roomscale)), 90.0, arg0, $00, $00, $05, "", $00)
            local0\Field21 = $00
            local0\Field5 = $00
            arg0\Field19[$0E] = createpivot($00)
            positionentity(arg0\Field19[$0E], (arg0\Field3 + (3536.0 * roomscale)), (arg0\Field4 + (10256.0 * roomscale)), (arg0\Field5 + (5512.0 * roomscale)), $00)
            entityparent(arg0\Field19[$0E], arg0\Field2, $01)
            arg0\Field19[$0F] = createpivot($00)
            positionentity(arg0\Field19[$0F], (arg0\Field3 + (3536.0 * roomscale)), (arg0\Field4 + (10256.0 * roomscale)), (arg0\Field5 + (5824.0 * roomscale)), $00)
            entityparent(arg0\Field19[$0F], arg0\Field2, $01)
            arg0\Field19[$10] = createpivot($00)
            positionentity(arg0\Field19[$10], (arg0\Field3 + (3856.0 * roomscale)), (arg0\Field4 + (10256.0 * roomscale)), (arg0\Field5 + (5512.0 * roomscale)), $00)
            entityparent(arg0\Field19[$10], arg0\Field2, $01)
            arg0\Field19[$11] = createpivot($00)
            positionentity(arg0\Field19[$11], (arg0\Field3 + (3856.0 * roomscale)), (arg0\Field4 + (10256.0 * roomscale)), (arg0\Field5 + (5824.0 * roomscale)), $00)
            entityparent(arg0\Field19[$11], arg0\Field2, $01)
            arg0\Field19[$12] = createpivot($00)
            positionentity(arg0\Field19[$12], (arg0\Field3 + (3250.0 * roomscale)), (arg0\Field4 + (9896.0 * roomscale)), (arg0\Field5 + (6623.0 * roomscale)), $00)
            entityparent(arg0\Field19[$12], arg0\Field2, $01)
            arg0\Field19[$13] = createpivot($00)
            positionentity(arg0\Field19[$13], (arg0\Field3 + (3808.0 * roomscale)), (arg0\Field4 + (12320.0 * roomscale)), (arg0\Field5 - (13568.0 * roomscale)), $00)
            entityparent(arg0\Field19[$13], arg0\Field2, $01)
        Case "room372"
            local6 = createitem("Document SCP-372", "paper", (arg0\Field3 + (800.0 * roomscale)), (arg0\Field4 + (176.0 * roomscale)), (arg0\Field5 + (1108.0 * roomscale)), $00, $00, $00, 1.0, $00)
            rotateentity(local6\Field1, 0.0, (Float arg0\Field6), 0.0, $00)
            entityparent(local6\Field1, arg0\Field2, $01)
            local6 = createitem("Radio Transceiver", "radio", (arg0\Field3 + (800.0 * roomscale)), (arg0\Field4 + (112.0 * roomscale)), (arg0\Field5 + (944.0 * roomscale)), $00, $00, $00, 1.0, $00)
            local6\Field13 = 80.0
            entityparent(local6\Field1, arg0\Field2, $01)
            If (arg0\Field19[$03] = $00) Then
                arg0\Field19[$03] = loadmesh_strict(scpmodding_processfilepath("GFX\map\room372_hb.b3d"), arg0\Field2)
            EndIf
            entitypickmode(arg0\Field19[$03], $02, $01)
            entitytype(arg0\Field19[$03], $01, $00)
            entityalpha(arg0\Field19[$03], 0.0)
            arg0\Field21[$00] = createdoor(arg0\Field0, arg0\Field3, arg0\Field4, (arg0\Field5 - (368.0 * roomscale)), 0.0, arg0, $00, $01, $04, "", $00)
            arg0\Field21[$00]\Field21 = $00
            positionentity(arg0\Field21[$00]\Field3[$00], (arg0\Field3 - (496.0 * roomscale)), (arg0\Field4 + 0.7), (arg0\Field5 - (278.0 * roomscale)), $01)
            positionentity(arg0\Field21[$00]\Field3[$01], (entityx(arg0\Field21[$00]\Field3[$01], $01) + 0.025), entityy(arg0\Field21[$00]\Field3[$01], $01), entityz(arg0\Field21[$00]\Field3[$01], $01), $01)
            turnentity(arg0\Field21[$00]\Field3[$00], 0.0, 90.0, 0.0, $00)
        Case "room079"
            local0 = createdoor(arg0\Field0, (arg0\Field3 - (1648.0 * roomscale)), (arg0\Field4 - (10688.0 * roomscale)), (arg0\Field5 - (260.0 * roomscale)), 90.0, arg0, $00, $01, $06, "", $00)
            local0\Field9 = $01
            local0\Field21 = $00
            local0\Field5 = $00
            positionentity(local0\Field3[$01], (arg0\Field3 - (1418.0 * roomscale)), (arg0\Field4 - (10490.0 * roomscale)), (arg0\Field5 - (26.0 * roomscale)), $01)
            positionentity(local0\Field3[$00], (arg0\Field3 - (1894.0 * roomscale)), (arg0\Field4 - (10490.0 * roomscale)), (arg0\Field5 - (503.0 * roomscale)), $01)
            arg0\Field21[$00] = createdoor(arg0\Field0, (arg0\Field3 - (1484.0 * roomscale)), (arg0\Field4 - (10688.0 * roomscale)), (arg0\Field5 + (1205.0 * roomscale)), 90.0, arg0, $00, $01, $06, "", $00)
            arg0\Field21[$00]\Field9 = $01
            arg0\Field21[$00]\Field21 = $00
            arg0\Field21[$00]\Field5 = $00
            positionentity(arg0\Field21[$00]\Field3[$01], (arg0\Field3 - (1700.0 * roomscale)), (arg0\Field4 - (10490.0 * roomscale)), (arg0\Field5 + (777.5 * roomscale)), $01)
            rotateentity(arg0\Field21[$00]\Field3[$01], 0.0, 90.0, 0.0, $00)
            positionentity(arg0\Field21[$00]\Field3[$00], (arg0\Field3 - (1216.0 * roomscale)), (arg0\Field4 - (10490.0 * roomscale)), (arg0\Field5 + (1502.0 * roomscale)), $01)
            rotateentity(arg0\Field21[$00]\Field3[$00], 0.0, -90.0, 0.0, $00)
            local0 = createdoor(arg0\Field0, (arg0\Field3 - (1216.0 * roomscale)), (arg0\Field4 - (10688.0 * roomscale)), (arg0\Field5 + (888.0 * roomscale)), 0.0, arg0, $00, $00, $FFFFFFFF, "", $00)
            positionentity(local0\Field3[$00], entityx(local0\Field3[$00], $01), entityy(local0\Field3[$00], $01), (entityz(local0\Field3[$00], $01) + 0.061), $01)
            positionentity(local0\Field3[$01], entityx(local0\Field3[$01], $01), entityy(local0\Field3[$01], $01), (entityz(local0\Field3[$01], $01) - 0.061), $01)
            local0 = createdoor(arg0\Field0, arg0\Field3, arg0\Field4, (arg0\Field5 + (64.0 * roomscale)), 0.0, arg0, $00, $02, $06, "", $00)
            positionentity(local0\Field3[$00], entityx(local0\Field3[$00], $01), entityy(local0\Field3[$00], $01), entityz(local0\Field3[$00], $01), $01)
            freeentity(local0\Field3[$01])
            local0\Field3[$01] = $00
            local0\Field21 = $00
            local0\Field4 = $01
            local0\Field24 = $00
            local0\Field14 = $01
            arg0\Field21[$01] = createdoor(arg0\Field0, (arg0\Field3 + (512.0 * roomscale)), arg0\Field4, (arg0\Field5 - (256.0 * roomscale)), 90.0, arg0, $00, $03, $00, "", $00)
            arg0\Field21[$01]\Field21 = $00
            positionentity(arg0\Field21[$01]\Field3[$00], entityx(arg0\Field21[$01]\Field3[$00], $01), entityy(arg0\Field21[$01]\Field3[$00], $01), entityz(arg0\Field21[$01]\Field3[$00], $01), $01)
            positionentity(arg0\Field21[$01]\Field3[$01], entityx(arg0\Field21[$01]\Field3[$01], $01), entityy(arg0\Field21[$01]\Field3[$01], $01), entityz(arg0\Field21[$01]\Field3[$01], $01), $01)
            arg0\Field21[$02] = createdoor(arg0\Field0, (arg0\Field3 + (512.0 * roomscale)), (arg0\Field4 - (10240.0 * roomscale)), (arg0\Field5 - (256.0 * roomscale)), 90.0, arg0, $01, $03, $00, "", $00)
            arg0\Field21[$02]\Field21 = $00
            positionentity(arg0\Field21[$02]\Field3[$00], entityx(arg0\Field21[$02]\Field3[$00], $01), entityy(arg0\Field21[$02]\Field3[$00], $01), entityz(arg0\Field21[$02]\Field3[$00], $01), $01)
            positionentity(arg0\Field21[$02]\Field3[$01], entityx(arg0\Field21[$02]\Field3[$01], $01), entityy(arg0\Field21[$02]\Field3[$01], $01), entityz(arg0\Field21[$02]\Field3[$01], $01), $01)
            arg0\Field19[$03] = createpivot($00)
            positionentity(arg0\Field19[$03], (arg0\Field3 + (772.0 * roomscale)), (arg0\Field4 + (240.0 * roomscale)), (arg0\Field5 - (256.0 * roomscale)), $00)
            entityparent(arg0\Field19[$03], arg0\Field2, $01)
            arg0\Field19[$04] = createpivot($00)
            positionentity(arg0\Field19[$04], (arg0\Field3 + (772.0 * roomscale)), (arg0\Field4 - (10000.0 * roomscale)), (arg0\Field5 - (256.0 * roomscale)), $00)
            entityparent(arg0\Field19[$04], arg0\Field2, $01)
            If (arg0\Field19[$00] = $00) Then
                arg0\Field19[$00] = loadanimmesh_strict(scpmodding_processfilepath("GFX\map\079.b3d"), $00)
            EndIf
            scaleentity(arg0\Field19[$00], 1.3, 1.3, 1.3, $00)
            positionentity(arg0\Field19[$00], (arg0\Field3 + (166.0 * roomscale)), (arg0\Field4 - (10800.0 * roomscale)), (arg0\Field5 + (1606.0 * roomscale)), $00)
            entityparent(arg0\Field19[$00], arg0\Field2, $01)
            turnentity(arg0\Field19[$00], 0.0, -90.0, 0.0, $00)
            arg0\Field19[$01] = createsprite(arg0\Field19[$00])
            spriteviewmode(arg0\Field19[$01], $02)
            positionentity(arg0\Field19[$01], 0.082, 0.119, 0.01, $00)
            scalesprite(arg0\Field19[$01], 0.09, 0.0725)
            turnentity(arg0\Field19[$01], 0.0, 13.0, 0.0, $00)
            moveentity(arg0\Field19[$01], 0.0, 0.0, -0.022)
            entitytexture(arg0\Field19[$01], at\Field1[$03], $00, $00)
            hideentity(arg0\Field19[$01])
            arg0\Field19[$02] = createpivot($00)
            positionentity(arg0\Field19[$02], (arg0\Field3 - (2260.0 * roomscale)), (arg0\Field4 - (10688.0 * roomscale)), (arg0\Field5 + (1000.0 * roomscale)), $00)
            entityparent(arg0\Field19[$02], arg0\Field2, $01)
            local3 = createdecal($03, (arg0\Field3 - (2200.0 * roomscale)), ((arg0\Field4 - (10688.0 * roomscale)) + 0.01), (arg0\Field5 + (1000.0 * roomscale)), 90.0, rnd(360.0, 0.0), 0.0)
            local3\Field2 = 0.5
            scalesprite(local3\Field0, local3\Field2, local3\Field2)
            entityparent(local3\Field0, arg0\Field2, $01)
        Case "checkpoint1"
            arg0\Field21[$00] = createdoor($00, (arg0\Field3 + (48.0 * roomscale)), arg0\Field4, (arg0\Field5 - (128.0 * roomscale)), 0.0, arg0, $00, $00, $05, "", $00)
            positionentity(arg0\Field21[$00]\Field3[$00], (arg0\Field3 - (152.0 * roomscale)), entityy(arg0\Field21[$00]\Field3[$00], $01), (arg0\Field5 - (346.0 * roomscale)), $01)
            positionentity(arg0\Field21[$00]\Field3[$01], (arg0\Field3 - (152.0 * roomscale)), entityy(arg0\Field21[$00]\Field3[$01], $01), (arg0\Field5 + (90.0 * roomscale)), $01)
            arg0\Field21[$01] = createdoor($00, (arg0\Field3 - (352.0 * roomscale)), arg0\Field4, (arg0\Field5 - (128.0 * roomscale)), 0.0, arg0, $00, $00, $05, "", $00)
            arg0\Field21[$01]\Field22 = arg0\Field21[$00]
            arg0\Field21[$00]\Field22 = arg0\Field21[$01]
            arg0\Field19[$00] = createpivot(arg0\Field2)
            positionentity(arg0\Field19[$00], (arg0\Field3 + (720.0 * roomscale)), (arg0\Field4 + (120.0 * roomscale)), (arg0\Field5 + (333.0 * roomscale)), $01)
            arg0\Field21[$00]\Field10 = $15E
            arg0\Field21[$01]\Field10 = $15E
            local2 = createsecuritycam((arg0\Field3 + (192.0 * roomscale)), (arg0\Field4 + (704.0 * roomscale)), (arg0\Field5 - (960.0 * roomscale)), arg0, $00)
            local2\Field11 = 45.0
            local2\Field12 = 0.0
            turnentity(local2\Field3, 20.0, 0.0, 0.0, $00)
            arg0\Field19[$02] = copyentity(local11\Field2[$01], arg0\Field2)
            scaleentity(arg0\Field19[$02], 2.0, 2.0, 2.0, $00)
            positionentity(arg0\Field19[$02], (arg0\Field3 - (152.0 * roomscale)), (arg0\Field4 + (384.0 * roomscale)), (arg0\Field5 + (124.0 * roomscale)), $01)
            rotateentity(arg0\Field19[$02], 0.0, 180.0, 0.0, $00)
            entityfx(arg0\Field19[$02], $01)
            arg0\Field19[$03] = copyentity(local11\Field2[$01], arg0\Field2)
            scaleentity(arg0\Field19[$03], 2.0, 2.0, 2.0, $00)
            positionentity(arg0\Field19[$03], (arg0\Field3 - (152.0 * roomscale)), (arg0\Field4 + (384.0 * roomscale)), (arg0\Field5 - (380.0 * roomscale)), $01)
            rotateentity(arg0\Field19[$03], 0.0, 0.0, 0.0, $00)
            entityfx(arg0\Field19[$03], $01)
            If (maptemp((Int floor((arg0\Field3 / 8.0))), (Int (floor((arg0\Field5 / 8.0)) - 1.0))) = $00) Then
                createdoor(arg0\Field0, arg0\Field3, 0.0, (arg0\Field5 - 4.0), 0.0, arg0, $00, $00, $00, "ABCD", $00)
            EndIf
        Case "checkpoint2"
            arg0\Field21[$00] = createdoor($00, (arg0\Field3 - (48.0 * roomscale)), arg0\Field4, (arg0\Field5 + (128.0 * roomscale)), 0.0, arg0, $00, $00, $07, "", $00)
            positionentity(arg0\Field21[$00]\Field3[$00], (arg0\Field3 + (152.0 * roomscale)), entityy(arg0\Field21[$00]\Field3[$00], $01), (arg0\Field5 - (90.0 * roomscale)), $01)
            positionentity(arg0\Field21[$00]\Field3[$01], (arg0\Field3 + (152.0 * roomscale)), entityy(arg0\Field21[$00]\Field3[$01], $01), (arg0\Field5 + (346.0 * roomscale)), $01)
            arg0\Field21[$01] = createdoor($00, (arg0\Field3 + (352.0 * roomscale)), arg0\Field4, (arg0\Field5 + (128.0 * roomscale)), 0.0, arg0, $00, $00, $07, "", $00)
            arg0\Field21[$01]\Field22 = arg0\Field21[$00]
            arg0\Field21[$00]\Field22 = arg0\Field21[$01]
            arg0\Field19[$00] = createpivot(arg0\Field2)
            positionentity(arg0\Field19[$00], (arg0\Field3 - (720.0 * roomscale)), (arg0\Field4 + (120.0 * roomscale)), (arg0\Field5 + (464.0 * roomscale)), $01)
            arg0\Field19[$02] = copyentity(local11\Field2[$02], arg0\Field2)
            scaleentity(arg0\Field19[$02], 2.0, 2.0, 2.0, $00)
            positionentity(arg0\Field19[$02], (arg0\Field3 + (152.0 * roomscale)), (arg0\Field4 + (384.0 * roomscale)), (arg0\Field5 + (380.0 * roomscale)), $01)
            rotateentity(arg0\Field19[$02], 0.0, 180.0, 0.0, $00)
            entityfx(arg0\Field19[$02], $01)
            arg0\Field19[$03] = copyentity(local11\Field2[$02], arg0\Field2)
            scaleentity(arg0\Field19[$03], 2.0, 2.0, 2.0, $00)
            positionentity(arg0\Field19[$03], (arg0\Field3 + (152.0 * roomscale)), (arg0\Field4 + (384.0 * roomscale)), (arg0\Field5 - (124.0 * roomscale)), $01)
            rotateentity(arg0\Field19[$03], 0.0, 0.0, 0.0, $00)
            entityfx(arg0\Field19[$03], $01)
            arg0\Field21[$00]\Field10 = $15E
            arg0\Field21[$01]\Field10 = $15E
            If (maptemp((Int floor((arg0\Field3 / 8.0))), (Int (floor((arg0\Field5 / 8.0)) - 1.0))) = $00) Then
                createdoor(arg0\Field0, arg0\Field3, 0.0, (arg0\Field5 - 4.0), 0.0, arg0, $00, $00, $00, "ABCD", $00)
            EndIf
        Case "room2pit"
            local7 = $00
            For local8 = $FFFFFFFF To $01 Step $02
                For local10 = $FFFFFFFF To $01 Step $01
                    local15 = createemitter((arg0\Field3 + ((202.0 * roomscale) * (Float local8))), (arg0\Field4 + (8.0 * roomscale)), (arg0\Field5 + ((256.0 * roomscale) * (Float local10))), $00)
                    local15\Field10 = 30.0
                    local15\Field9 = 0.0045
                    local15\Field11 = 0.007
                    local15\Field12 = -0.016
                    arg0\Field19[local7] = local15\Field0
                    If (local7 < $03) Then
                        turnentity(local15\Field0, 0.0, -90.0, 0.0, $01)
                    Else
                        turnentity(local15\Field0, 0.0, 90.0, 0.0, $01)
                    EndIf
                    turnentity(local15\Field0, -45.0, 0.0, 0.0, $01)
                    entityparent(local15\Field0, arg0\Field2, $01)
                    local7 = (local7 + $01)
                Next
            Next
            arg0\Field19[$06] = createpivot($00)
            positionentity(arg0\Field19[$06], (arg0\Field3 + (640.0 * roomscale)), (arg0\Field4 + (8.0 * roomscale)), (arg0\Field5 - (896.0 * roomscale)), $00)
            entityparent(arg0\Field19[$06], arg0\Field2, $01)
            arg0\Field19[$07] = createpivot($00)
            positionentity(arg0\Field19[$07], (arg0\Field3 - (864.0 * roomscale)), (arg0\Field4 - (400.0 * roomscale)), (arg0\Field5 - (632.0 * roomscale)), $00)
            entityparent(arg0\Field19[$07], arg0\Field2, $01)
            local0 = createdoor(arg0\Field0, (arg0\Field3 - (864.0 * roomscale)), (arg0\Field4 - (400.0 * roomscale)), (arg0\Field5 - (632.0 * roomscale)), 90.0, arg0, $00, $00, $00, "", $00)
            local0\Field21 = $00
            local0\Field4 = $01
            local0\Field24 = $00
            local0\Field14 = $01
            freeentity(local0\Field3[$00])
            local0\Field3[$00] = $00
            freeentity(local0\Field3[$01])
            local0\Field3[$01] = $00
        Case "room2testroom2"
            arg0\Field19[$00] = createpivot($00)
            positionentity(arg0\Field19[$00], (arg0\Field3 - (640.0 * roomscale)), (arg0\Field4 + 0.5), (arg0\Field5 - (912.0 * roomscale)), $00)
            arg0\Field19[$01] = createpivot($00)
            positionentity(arg0\Field19[$01], (arg0\Field3 - (669.0 * roomscale)), (arg0\Field4 + 0.5), (arg0\Field5 - (16.0 * roomscale)), $00)
            local16 = loadtexture_strict(scpmodding_processfilepath("GFX\map\glass.png"), $03)
            arg0\Field19[$02] = createsprite($00)
            entitytexture(arg0\Field19[$02], local16, $00, $00)
            spriteviewmode(arg0\Field19[$02], $02)
            scalesprite(arg0\Field19[$02], ((182.0 * roomscale) * 0.5), ((192.0 * roomscale) * 0.5))
            positionentity(arg0\Field19[$02], (arg0\Field3 - (632.0 * roomscale)), (arg0\Field4 + (224.0 * roomscale)), (arg0\Field5 - (208.0 * roomscale)), $00)
            turnentity(arg0\Field19[$02], 0.0, 180.0, 0.0, $00)
            hideentity(arg0\Field19[$02])
            freetexture(local16)
            For local7 = $00 To $02 Step $01
                entityparent(arg0\Field19[local7], arg0\Field2, $01)
            Next
            arg0\Field21[$00] = createdoor(arg0\Field0, (arg0\Field3 - (240.0 * roomscale)), arg0\Field4, (arg0\Field5 + (640.0 * roomscale)), 90.0, arg0, $00, $00, $03, "", $00)
            arg0\Field21[$00]\Field21 = $00
            arg0\Field21[$00]\Field5 = $00
            local0 = createdoor(arg0\Field0, (arg0\Field3 - (512.0 * roomscale)), arg0\Field4, (arg0\Field5 + (384.0 * roomscale)), 0.0, arg0, $00, $00, $00, "", $00)
            local0\Field21 = $00
            positionentity(local0\Field3[$00], entityx(local0\Field3[$00], $01), entityy(local0\Field3[$00], $01), (entityz(local0\Field3[$00], $01) + 0.031), $01)
            positionentity(local0\Field3[$01], entityx(local0\Field3[$01], $01), entityy(local0\Field3[$01], $01), (entityz(local0\Field3[$01], $01) - 0.031), $01)
            local6 = createitem("S-NAV 300 Navigator", "nav", (arg0\Field3 - (914.0 * roomscale)), (arg0\Field4 + (137.0 * roomscale)), (arg0\Field5 + (61.0 * roomscale)), $00, $00, $00, 1.0, $00)
            local6\Field13 = 20.0
            entityparent(local6\Field1, arg0\Field2, $01)
            local6 = createitem("Level 2 Key Card", "key2", (arg0\Field3 - (342.0 * roomscale)), (arg0\Field4 + (264.0 * roomscale)), (arg0\Field5 + (102.0 * roomscale)), $00, $00, $00, 1.0, $00)
            entityparent(local6\Field1, arg0\Field2, $01)
            rotateentity(local6\Field1, 0.0, 180.0, 0.0, $00)
        Case "room3tunnel"
            arg0\Field19[$00] = createpivot(arg0\Field2)
            positionentity(arg0\Field19[$00], (arg0\Field3 - (190.0 * roomscale)), (arg0\Field4 + (4.0 * roomscale)), (arg0\Field5 + (190.0 * roomscale)), $01)
        Case "room2toilets"
            arg0\Field19[$00] = createpivot($00)
            positionentity(arg0\Field19[$00], (arg0\Field3 + (1040.0 * roomscale)), (arg0\Field4 + (192.0 * roomscale)), arg0\Field5, $00)
            arg0\Field19[$01] = createpivot($00)
            positionentity(arg0\Field19[$01], (arg0\Field3 + (1530.0 * roomscale)), (arg0\Field4 + 0.5), (arg0\Field5 + (512.0 * roomscale)), $00)
            arg0\Field19[$02] = createpivot($00)
            positionentity(arg0\Field19[$02], (arg0\Field3 + (1535.0 * roomscale)), (arg0\Field4 + (150.0 * roomscale)), (arg0\Field5 + (512.0 * roomscale)), $00)
            For local7 = $00 To $02 Step $01
                entityparent(arg0\Field19[local7], arg0\Field2, $01)
            Next
        Case "room2storage"
            arg0\Field21[$00] = createdoor(arg0\Field0, (arg0\Field3 - (1288.0 * roomscale)), arg0\Field4, arg0\Field5, 270.0, arg0, $00, $00, $00, "", $00)
            arg0\Field21[$01] = createdoor(arg0\Field0, (arg0\Field3 - (760.0 * roomscale)), arg0\Field4, arg0\Field5, 270.0, arg0, $00, $00, $00, "", $00)
            arg0\Field21[$02] = createdoor(arg0\Field0, (arg0\Field3 - (264.0 * roomscale)), arg0\Field4, arg0\Field5, 270.0, arg0, $00, $00, $00, "", $00)
            arg0\Field21[$03] = createdoor(arg0\Field0, (arg0\Field3 + (264.0 * roomscale)), arg0\Field4, arg0\Field5, 270.0, arg0, $00, $00, $00, "", $00)
            arg0\Field21[$04] = createdoor(arg0\Field0, (arg0\Field3 + (760.0 * roomscale)), arg0\Field4, arg0\Field5, 270.0, arg0, $00, $00, $00, "", $00)
            arg0\Field21[$05] = createdoor(arg0\Field0, (arg0\Field3 + (1288.0 * roomscale)), arg0\Field4, arg0\Field5, 270.0, arg0, $00, $00, $00, "", $00)
            For local7 = $00 To $05 Step $01
                moveentity(arg0\Field21[local7]\Field3[$00], 0.0, 0.0, -8.0)
                moveentity(arg0\Field21[local7]\Field3[$01], 0.0, 0.0, -8.0)
                arg0\Field21[local7]\Field21 = $00
                arg0\Field21[local7]\Field5 = $00
            Next
            local6 = createitem("Document SCP-939", "paper", (arg0\Field3 + (352.0 * roomscale)), (arg0\Field4 + (176.0 * roomscale)), (arg0\Field5 + (256.0 * roomscale)), $00, $00, $00, 1.0, $00)
            entityparent(local6\Field1, arg0\Field2, $01)
            rotateentity(local6\Field1, 0.0, (Float (arg0\Field6 + $04)), 0.0, $00)
            local6 = createitem("9V Battery", "bat", (arg0\Field3 + (352.0 * roomscale)), (arg0\Field4 + (112.0 * roomscale)), (arg0\Field5 + (448.0 * roomscale)), $00, $00, $00, 1.0, $00)
            entityparent(local6\Field1, arg0\Field2, $01)
            local6 = createitem("Empty Cup", "emptycup", (arg0\Field3 - (672.0 * roomscale)), (arg0\Field4 + (240.0 * roomscale)), (arg0\Field5 + (288.0 * roomscale)), $00, $00, $00, 1.0, $00)
            entityparent(local6\Field1, arg0\Field2, $01)
            local6 = createitem("Level 0 Key Card", "key0", (arg0\Field3 - (672.0 * roomscale)), (arg0\Field4 + (240.0 * roomscale)), (arg0\Field5 + (224.0 * roomscale)), $00, $00, $00, 1.0, $00)
            entityparent(local6\Field1, arg0\Field2, $01)
        Case "room2sroom"
            local0 = createdoor(arg0\Field0, (arg0\Field3 + (1440.0 * roomscale)), (224.0 * roomscale), (arg0\Field5 + (32.0 * roomscale)), 270.0, arg0, $00, $00, $06, "", $00)
            local0\Field21 = $00
            local0\Field5 = $00
            positionentity(local0\Field3[$00], (entityx(local0\Field3[$00], $01) + 0.061), entityy(local0\Field3[$00], $01), entityz(local0\Field3[$00], $01), $01)
            positionentity(local0\Field3[$01], (entityx(local0\Field3[$01], $01) - 0.061), entityy(local0\Field3[$01], $01), entityz(local0\Field3[$01], $01), $01)
            local6 = createitem("Some SCP-420-J", "scp420j", (arg0\Field3 + (1776.0 * roomscale)), (arg0\Field4 + (400.0 * roomscale)), (arg0\Field5 + (427.0 * roomscale)), $00, $00, $00, 1.0, $00)
            entityparent(local6\Field1, arg0\Field2, $01)
            local6 = createitem("Some SCP-420-J", "scp420j", (arg0\Field3 + (1808.0 * roomscale)), (arg0\Field4 + (400.0 * roomscale)), (arg0\Field5 + (435.0 * roomscale)), $00, $00, $00, 1.0, $00)
            entityparent(local6\Field1, arg0\Field2, $01)
            local6 = createitem("Level 5 Key Card", "key5", (arg0\Field3 + (2232.0 * roomscale)), (arg0\Field4 + (392.0 * roomscale)), (arg0\Field5 + (387.0 * roomscale)), $00, $00, $00, 1.0, $00)
            entityparent(local6\Field1, arg0\Field2, $01)
            rotateentity(local6\Field1, 0.0, (Float arg0\Field6), 0.0, $00)
            local6 = createitem("Nuclear Device Document", "paper", (arg0\Field3 + (2248.0 * roomscale)), (arg0\Field4 + (440.0 * roomscale)), (arg0\Field5 + (372.0 * roomscale)), $00, $00, $00, 1.0, $00)
            entityparent(local6\Field1, arg0\Field2, $01)
            local6 = createitem("Radio Transceiver", "radio", (arg0\Field3 + (2240.0 * roomscale)), (arg0\Field4 + (320.0 * roomscale)), (arg0\Field5 + (128.0 * roomscale)), $00, $00, $00, 1.0, $00)
            entityparent(local6\Field1, arg0\Field2, $01)
        Case "room2shaft"
            local0 = createdoor(arg0\Field0, (arg0\Field3 + (1552.0 * roomscale)), arg0\Field4, (arg0\Field5 + (552.0 * roomscale)), 0.0, arg0, $00, $00, $00, "", $00)
            positionentity(local0\Field3[$00], entityx(local0\Field3[$00], $01), entityy(local0\Field3[$00], $01), (arg0\Field5 + (518.0 * roomscale)), $01)
            positionentity(local0\Field3[$01], entityx(local0\Field3[$01], $01), entityy(local0\Field3[$01], $01), (arg0\Field5 + (575.0 * roomscale)), $01)
            local0\Field21 = $00
            local0 = createdoor(arg0\Field0, (arg0\Field3 + (256.0 * roomscale)), arg0\Field4, (arg0\Field5 + (744.0 * roomscale)), 90.0, arg0, $00, $00, $04, "", $00)
            local0\Field21 = $00
            local6 = createitem("Level 3 Key Card", "key3", (arg0\Field3 + (1119.0 * roomscale)), (arg0\Field4 + (233.0 * roomscale)), (arg0\Field5 + (494.0 * roomscale)), $00, $00, $00, 1.0, $00)
            entityparent(local6\Field1, arg0\Field2, $01)
            local6 = createitem("First Aid Kit", "firstaid", (arg0\Field3 + (1035.0 * roomscale)), (arg0\Field4 + (145.0 * roomscale)), (arg0\Field5 + (56.0 * roomscale)), $00, $00, $00, 1.0, $00)
            entityparent(local6\Field1, arg0\Field2, $01)
            rotateentity(local6\Field1, 0.0, 90.0, 0.0, $00)
            local6 = createitem("9V Battery", "bat", (arg0\Field3 + (1930.0 * roomscale)), (arg0\Field4 + (97.0 * roomscale)), (arg0\Field5 + (256.0 * roomscale)), $00, $00, $00, 1.0, $00)
            entityparent(local6\Field1, arg0\Field2, $01)
            local6 = createitem("9V Battery", "bat", (arg0\Field3 + (1061.0 * roomscale)), (arg0\Field4 + (161.0 * roomscale)), (arg0\Field5 + (494.0 * roomscale)), $00, $00, $00, 1.0, $00)
            entityparent(local6\Field1, arg0\Field2, $01)
            local6 = createitem("ReVision Eyedrops", "eyedrops", (arg0\Field3 + (1930.0 * roomscale)), (arg0\Field4 + (225.0 * roomscale)), (arg0\Field5 + (128.0 * roomscale)), $00, $00, $00, 1.0, $00)
            entityparent(local6\Field1, arg0\Field2, $01)
            arg0\Field19[$00] = createpivot($00)
            positionentity(arg0\Field19[$00], (arg0\Field3 + (1560.0 * roomscale)), arg0\Field4, (arg0\Field5 + (250.0 * roomscale)), $00)
            entityparent(arg0\Field19[$00], arg0\Field2, $01)
            arg0\Field19[$01] = createpivot($00)
            positionentity(arg0\Field19[$01], (arg0\Field3 + (1344.0 * roomscale)), (arg0\Field4 - (732.0 * roomscale)), (arg0\Field5 - (384.0 * roomscale)), $00)
            entityparent(arg0\Field19[$01], arg0\Field2, $01)
            arg0\Field19[$02] = createbutton((arg0\Field3 + (1180.0 * roomscale)), (arg0\Field4 + (180.0 * roomscale)), (arg0\Field5 - (552.0 * roomscale)), 0.0, 270.0, 0.0, $04)
            entityparent(arg0\Field19[$02], arg0\Field2, $01)
            local3 = createdecal($03, (arg0\Field3 + (1334.0 * roomscale)), ((arg0\Field4 - (796.0 * roomscale)) + 0.01), (arg0\Field5 - (220.0 * roomscale)), 90.0, rnd(360.0, 0.0), 0.0)
            local3\Field2 = 0.25
            scalesprite(local3\Field0, local3\Field2, local3\Field2)
            entityparent(local3\Field0, arg0\Field2, $01)
        Case "room2poffices"
            local0 = createdoor(arg0\Field0, (arg0\Field3 + (240.0 * roomscale)), arg0\Field4, (arg0\Field5 + (448.0 * roomscale)), 270.0, arg0, $00, $00, $00, (Str accesscode), $00)
            local0\Field21 = $00
            local0\Field5 = $00
            positionentity(local0\Field3[$00], (entityx(local0\Field3[$00], $01) + 0.061), entityy(local0\Field3[$00], $01), entityz(local0\Field3[$00], $01), $01)
            positionentity(local0\Field3[$01], (entityx(local0\Field3[$01], $01) - 0.061), entityy(local0\Field3[$01], $01), entityz(local0\Field3[$01], $01), $01)
            local0 = createdoor(arg0\Field0, (arg0\Field3 - (496.0 * roomscale)), arg0\Field4, arg0\Field5, 270.0, arg0, $00, $00, $00, "1311", $00)
            local0\Field21 = $00
            local0\Field5 = $00
            local0\Field4 = $01
            positionentity(local0\Field3[$00], (entityx(local0\Field3[$00], $01) + 0.061), entityy(local0\Field3[$00], $01), entityz(local0\Field3[$00], $01), $01)
            positionentity(local0\Field3[$01], (entityx(local0\Field3[$01], $01) - 0.061), entityy(local0\Field3[$01], $01), entityz(local0\Field3[$01], $01), $01)
            local0 = createdoor(arg0\Field0, (arg0\Field3 + (240.0 * roomscale)), arg0\Field4, (arg0\Field5 - (576.0 * roomscale)), 270.0, arg0, $00, $00, $00, "7816", $00)
            local0\Field21 = $00
            local0\Field5 = $00
            positionentity(local0\Field3[$00], (entityx(local0\Field3[$00], $01) + 0.061), entityy(local0\Field3[$00], $01), entityz(local0\Field3[$00], $01), $01)
            positionentity(local0\Field3[$01], (entityx(local0\Field3[$01], $01) - 0.061), entityy(local0\Field3[$01], $01), entityz(local0\Field3[$01], $01), $01)
            local6 = createitem("Mysterious Note", "paper", (arg0\Field3 + (736.0 * roomscale)), (arg0\Field4 + (224.0 * roomscale)), (arg0\Field5 + (544.0 * roomscale)), $00, $00, $00, 1.0, $00)
            entityparent(local6\Field1, arg0\Field2, $01)
            local6 = createitem("Ballistic Vest", "vest", (arg0\Field3 + (608.0 * roomscale)), (arg0\Field4 + (112.0 * roomscale)), (arg0\Field5 + (32.0 * roomscale)), $00, $00, $00, 1.0, $00)
            entityparent(local6\Field1, arg0\Field2, $01)
            rotateentity(local6\Field1, 0.0, 90.0, 0.0, $00)
            local6 = createitem("Incident Report SCP-106-0204", "paper", (arg0\Field3 + (704.0 * roomscale)), (arg0\Field4 + (183.0 * roomscale)), (arg0\Field5 - (576.0 * roomscale)), $00, $00, $00, 1.0, $00)
            entityparent(local6\Field1, arg0\Field2, $01)
            local6 = createitem("Journal Page", "paper", (arg0\Field3 + (912.0 * roomscale)), (arg0\Field4 + (176.0 * roomscale)), (arg0\Field5 - (160.0 * roomscale)), $00, $00, $00, 1.0, $00)
            entityparent(local6\Field1, arg0\Field2, $01)
            local6 = createitem("First Aid Kit", "firstaid", (arg0\Field3 + (912.0 * roomscale)), (arg0\Field4 + (112.0 * roomscale)), (arg0\Field5 - (336.0 * roomscale)), $00, $00, $00, 1.0, $00)
            entityparent(local6\Field1, arg0\Field2, $01)
            rotateentity(local6\Field1, 0.0, 90.0, 0.0, $00)
            local6 = createitem("SCP-085 Note", "paper", (arg0\Field3 - (760.0 * roomscale)), (arg0\Field4 + (224.0 * roomscale)), (arg0\Field5 + (452.0 * roomscale)), $00, $00, $00, 1.0, $00)
            entityparent(local6\Field1, arg0\Field2, $01)
            local6 = createitem("References Document", "paper", (arg0\Field3 - (1423.0 * roomscale)), (arg0\Field4 + (224.0 * roomscale)), (arg0\Field5 + (66.0 * roomscale)), $00, $00, $00, 1.0, $00)
            entityparent(local6\Field1, arg0\Field2, $01)
            local6 = createitem("Ballistic Helmet", "helmet", (arg0\Field3 - (720.0 * roomscale)), (arg0\Field4 + (224.0 * roomscale)), (arg0\Field5 + (250.0 * roomscale)), $00, $00, $00, 1.0, $00)
            entityparent(local6\Field1, arg0\Field2, $01)
        Case "room2poffices2"
            local0 = createdoor(arg0\Field0, (arg0\Field3 + (240.0 * roomscale)), arg0\Field4, (arg0\Field5 + (48.0 * roomscale)), 270.0, arg0, $00, $00, $03, "", $00)
            local0\Field21 = $00
            local0\Field5 = $00
            positionentity(local0\Field3[$00], (entityx(local0\Field3[$00], $01) + 0.061), entityy(local0\Field3[$00], $01), entityz(local0\Field3[$00], $01), $01)
            positionentity(local0\Field3[$01], (entityx(local0\Field3[$01], $01) - 0.061), entityy(local0\Field3[$01], $01), entityz(local0\Field3[$01], $01), $01)
            arg0\Field21[$00] = createdoor(arg0\Field0, (arg0\Field3 - (432.0 * roomscale)), 0.0, arg0\Field5, 90.0, arg0, $00, $00, $00, "1234", $00)
            arg0\Field21[$00]\Field21 = $00
            arg0\Field21[$00]\Field5 = $00
            arg0\Field21[$00]\Field4 = $01
            positionentity(arg0\Field21[$00]\Field3[$00], (entityx(arg0\Field21[$00]\Field3[$00], $01) - 0.061), entityy(arg0\Field21[$00]\Field3[$00], $01), entityz(arg0\Field21[$00]\Field3[$00], $01), $01)
            freeentity(arg0\Field21[$00]\Field3[$01])
            arg0\Field21[$00]\Field3[$01] = $00
            local3 = createdecal($00, (arg0\Field3 - (808.0 * roomscale)), (arg0\Field4 + 0.005), (arg0\Field5 - (72.0 * roomscale)), 90.0, (Float rand($168, $01)), 0.0)
            entityparent(local3\Field0, arg0\Field2, $01)
            local3 = createdecal($02, (arg0\Field3 - (808.0 * roomscale)), (arg0\Field4 + 0.01), (arg0\Field5 - (72.0 * roomscale)), 90.0, (Float rand($168, $01)), 0.0)
            local3\Field2 = 0.3
            scalesprite(local3\Field0, local3\Field2, local3\Field2)
            entityparent(local3\Field0, arg0\Field2, $01)
            local3 = createdecal($00, (arg0\Field3 - (432.0 * roomscale)), (arg0\Field4 + 0.01), arg0\Field5, 90.0, (Float rand($168, $01)), 0.0)
            entityparent(local3\Field0, arg0\Field2, $01)
            arg0\Field19[$00] = createpivot($00)
            positionentity(arg0\Field19[$00], (arg0\Field3 - (808.0 * roomscale)), (arg0\Field4 + 1.0), (arg0\Field5 - (72.0 * roomscale)), $00)
            entityparent(arg0\Field19[$00], arg0\Field2, $01)
            local6 = createitem("Dr. L's Burnt Note", "paper", (arg0\Field3 - (688.0 * roomscale)), 1.0, (arg0\Field5 - (16.0 * roomscale)), $00, $00, $00, 1.0, $00)
            entityparent(local6\Field1, arg0\Field2, $01)
            local6 = createitem("Dr L's Burnt Note", "paper", (arg0\Field3 - (808.0 * roomscale)), 1.0, (arg0\Field5 - (72.0 * roomscale)), $00, $00, $00, 1.0, $00)
            entityparent(local6\Field1, arg0\Field2, $01)
            local6 = createitem("The Modular Site Project", "paper", (arg0\Field3 + (622.0 * roomscale)), (arg0\Field4 + (125.0 * roomscale)), (arg0\Field5 - (73.0 * roomscale)), $00, $00, $00, 1.0, $00)
            entityparent(local6\Field1, arg0\Field2, $01)
        Case "room2elevator"
            arg0\Field19[$00] = createpivot($00)
            positionentity(arg0\Field19[$00], (arg0\Field3 + (888.0 * roomscale)), (arg0\Field4 + (240.0 * roomscale)), arg0\Field5, $00)
            arg0\Field19[$01] = createpivot($00)
            positionentity(arg0\Field19[$01], ((arg0\Field3 + (1024.0 * roomscale)) - 0.01), (arg0\Field4 + (120.0 * roomscale)), arg0\Field5, $00)
            For local7 = $00 To $01 Step $01
                entityparent(arg0\Field19[local7], arg0\Field2, $01)
            Next
            arg0\Field21[$00] = createdoor(arg0\Field0, (arg0\Field3 + (448.0 * roomscale)), arg0\Field4, arg0\Field5, 90.0, arg0, $00, $03, $00, "", $00)
            arg0\Field21[$00]\Field21 = $00
            arg0\Field21[$00]\Field5 = $01
            arg0\Field21[$00]\Field4 = $01
        Case "room2cafeteria"
            arg0\Field19[$00] = createpivot($00)
            positionentity(arg0\Field19[$00], (arg0\Field3 + (1847.0 * roomscale)), (arg0\Field4 - (240.0 * roomscale)), (arg0\Field5 - (321.0 * roomscale)), $00)
            entityparent(arg0\Field19[$00], arg0\Field2, $01)
            arg0\Field19[$01] = createpivot($00)
            positionentity(arg0\Field19[$01], (arg0\Field3 + (1780.0 * roomscale)), (arg0\Field4 - (248.0 * roomscale)), (arg0\Field5 - (276.0 * roomscale)), $00)
            entityparent(arg0\Field19[$01], arg0\Field2, $01)
            arg0\Field19[$02] = createpivot($00)
            positionentity(arg0\Field19[$02], arg0\Field3, (arg0\Field4 - (248.0 * roomscale)), (arg0\Field5 - (120.0 * roomscale)), $00)
            entityparent(arg0\Field19[$02], arg0\Field2, $01)
            local6 = createitem("cup", "cup", (arg0\Field3 - (508.0 * roomscale)), (arg0\Field4 - (187.0 * roomscale)), (arg0\Field5 + (284.0 * roomscale)), $F0, $AF, $46, 1.0, $00)
            entityparent(local6\Field1, arg0\Field2, $01)
            local6\Field0 = "Cup of Orange Juice"
            local6 = createitem("cup", "cup", (arg0\Field3 + (1412.0 * roomscale)), (arg0\Field4 - (187.0 * roomscale)), (arg0\Field5 - (716.0 * roomscale)), $57, $3E, $2D, 1.0, $00)
            entityparent(local6\Field1, arg0\Field2, $01)
            local6\Field0 = "Cup of Coffee"
            local6 = createitem("Empty Cup", "emptycup", (arg0\Field3 - (540.0 * roomscale)), (arg0\Field4 - (187.0 * roomscale)), (arg0\Field5 + (124.0 * roomscale)), $00, $00, $00, 1.0, $00)
            entityparent(local6\Field1, arg0\Field2, $01)
            local6 = createitem("Quarter", "25ct", (arg0\Field3 - (447.0 * roomscale)), (arg0\Field4 - (334.0 * roomscale)), (arg0\Field5 + (36.0 * roomscale)), $00, $00, $00, 1.0, $00)
            entityparent(local6\Field1, arg0\Field2, $01)
            local6 = createitem("Quarter", "25ct", (arg0\Field3 + (1402.0 * roomscale)), (arg0\Field4 - (334.0 * roomscale)), (arg0\Field5 - (102.0 * roomscale)), $00, $00, $00, 1.0, $00)
            entityparent(local6\Field1, arg0\Field2, $01)
        Case "room2nuke"
            local0 = createdoor(arg0\Field0, (arg0\Field3 + (576.0 * roomscale)), arg0\Field4, (arg0\Field5 + (152.0 * roomscale)), 90.0, arg0, $00, $00, $07, "", $00)
            local0\Field21 = $00
            local0\Field5 = $00
            positionentity(local0\Field3[$00], entityx(local0\Field3[$00], $01), entityy(local0\Field3[$00], $01), (entityz(local0\Field3[$00], $01) - 0.09), $01)
            positionentity(local0\Field3[$01], entityx(local0\Field3[$01], $01), entityy(local0\Field3[$01], $01), (entityz(local0\Field3[$01], $01) + 0.09), $01)
            freeentity(local0\Field1)
            local0\Field1 = $00
            local0 = createdoor(arg0\Field0, (arg0\Field3 - (544.0 * roomscale)), (arg0\Field4 + (1504.0 * roomscale)), (arg0\Field5 + (737.5 * roomscale)), 90.0, arg0, $00, $00, $07, "", $00)
            local0\Field21 = $00
            local0\Field5 = $00
            positionentity(local0\Field3[$00], entityx(local0\Field3[$00], $01), entityy(local0\Field3[$00], $01), (arg0\Field5 + (608.0 * roomscale)), $01)
            positionentity(local0\Field3[$01], entityx(local0\Field3[$01], $01), entityy(local0\Field3[$01], $01), (arg0\Field5 + (608.0 * roomscale)), $01)
            arg0\Field21[$00] = createdoor(arg0\Field0, (arg0\Field3 + (1192.0 * roomscale)), arg0\Field4, arg0\Field5, 90.0, arg0, $01, $03, $00, "", $00)
            arg0\Field21[$00]\Field21 = $00
            arg0\Field21[$00]\Field5 = $01
            positionentity(arg0\Field21[$00]\Field3[$00], (entityx(arg0\Field21[$00]\Field3[$00], $01) - 0.031), entityy(arg0\Field21[$00]\Field3[$00], $01), entityz(arg0\Field21[$00]\Field3[$00], $01), $01)
            positionentity(arg0\Field21[$00]\Field3[$01], (entityx(arg0\Field21[$00]\Field3[$01], $01) + 0.031), entityy(arg0\Field21[$00]\Field3[$01], $01), entityz(arg0\Field21[$00]\Field3[$01], $01), $01)
            arg0\Field21[$01] = createdoor(arg0\Field0, (arg0\Field3 + (680.0 * roomscale)), (arg0\Field4 + (1504.0 * roomscale)), arg0\Field5, 90.0, arg0, $00, $03, $00, "", $00)
            arg0\Field21[$01]\Field21 = $00
            arg0\Field21[$01]\Field5 = $00
            positionentity(arg0\Field21[$01]\Field3[$00], (entityx(arg0\Field21[$01]\Field3[$00], $01) - 0.031), entityy(arg0\Field21[$01]\Field3[$00], $01), entityz(arg0\Field21[$01]\Field3[$00], $01), $01)
            positionentity(arg0\Field21[$01]\Field3[$01], (entityx(arg0\Field21[$01]\Field3[$01], $01) + 0.031), entityy(arg0\Field21[$01]\Field3[$01], $01), entityz(arg0\Field21[$01]\Field3[$01], $01), $01)
            For local17 = $00 To $01 Step $01
                arg0\Field19[(local17 Shl $01)] = copyentity(local11\Field5[$00], $00)
                arg0\Field19[((local17 Shl $01) + $01)] = copyentity(local11\Field5[$01], $00)
                arg0\Field20[local17] = arg0\Field19[((local17 Shl $01) + $01)]
                For local7 = $00 To $01 Step $01
                    scaleentity(arg0\Field19[((local17 Shl $01) + local7)], 0.04, 0.04, 0.04, $00)
                    positionentity(arg0\Field19[((local17 Shl $01) + local7)], (arg0\Field3 - (975.0 * roomscale)), (arg0\Field4 + (1712.0 * roomscale)), (arg0\Field5 - ((502.0 - (132.0 * (Float local17))) * roomscale)), $01)
                    entityparent(arg0\Field19[((local17 Shl $01) + local7)], arg0\Field2, $01)
                Next
                rotateentity(arg0\Field19[(local17 Shl $01)], 0.0, -270.0, 0.0, $00)
                rotateentity(arg0\Field19[((local17 Shl $01) + $01)], 10.0, -450.0, 0.0, $00)
                entitypickmode(arg0\Field19[((local17 Shl $01) + $01)], $01, $00)
                entityradius(arg0\Field19[((local17 Shl $01) + $01)], 0.1, 0.0)
            Next
            local6 = createitem("Nuclear Device Document", "paper", (arg0\Field3 - (944.0 * roomscale)), (arg0\Field4 + (1652.0 * roomscale)), (arg0\Field5 - (706.0 * roomscale)), $00, $00, $00, 1.0, $00)
            entityparent(local6\Field1, arg0\Field2, $01)
            local6 = createitem("Ballistic Vest", "vest", (arg0\Field3 - (768.0 * roomscale)), (arg0\Field4 + (1684.0 * roomscale)), (arg0\Field5 - (768.0 * roomscale)), $00, $00, $00, 1.0, $00)
            entityparent(local6\Field1, arg0\Field2, $01)
            rotateentity(local6\Field1, 0.0, -90.0, 0.0, $00)
            local2 = createsecuritycam((arg0\Field3 + (624.0 * roomscale)), (arg0\Field4 + (1888.0 * roomscale)), (arg0\Field5 - (312.0 * roomscale)), arg0, $00)
            local2\Field11 = 90.0
            local2\Field12 = 45.0
            turnentity(local2\Field3, 20.0, 0.0, 0.0, $00)
            arg0\Field19[$04] = createpivot($00)
            positionentity(arg0\Field19[$04], (arg0\Field3 + (1496.0 * roomscale)), (arg0\Field4 + (240.0 * roomscale)), arg0\Field5, $00)
            arg0\Field19[$05] = createpivot($00)
            positionentity(arg0\Field19[$05], (arg0\Field3 + (984.0 * roomscale)), (arg0\Field4 + (1744.0 * roomscale)), arg0\Field5, $00)
            arg0\Field19[$06] = createpivot($00)
            positionentity(arg0\Field19[$06], (arg0\Field3 + (1110.0 * roomscale)), (arg0\Field4 + (36.0 * roomscale)), (arg0\Field5 - (208.0 * roomscale)), $00)
            For local7 = $04 To $06 Step $01
                entityparent(arg0\Field19[local7], arg0\Field2, $01)
            Next
        Case "room2tunnel"
            arg0\Field19[$00] = createpivot($00)
            positionentity(arg0\Field19[$00], (arg0\Field3 + (2640.0 * roomscale)), (arg0\Field4 - (2496.0 * roomscale)), (arg0\Field5 + (400.0 * roomscale)), $00)
            arg0\Field19[$01] = createpivot($00)
            positionentity(arg0\Field19[$01], (arg0\Field3 - (4336.0 * roomscale)), (arg0\Field4 - (2496.0 * roomscale)), (arg0\Field5 - (2512.0 * roomscale)), $00)
            arg0\Field19[$02] = createpivot($00)
            rotateentity(arg0\Field19[$02], 0.0, 180.0, 0.0, $01)
            positionentity(arg0\Field19[$02], (arg0\Field3 + (552.0 * roomscale)), (arg0\Field4 + (240.0 * roomscale)), (arg0\Field5 + (656.0 * roomscale)), $00)
            For local7 = $00 To $02 Step $01
                entityparent(arg0\Field19[local7], arg0\Field2, $01)
            Next
            arg0\Field19[$04] = createpivot($00)
            positionentity(arg0\Field19[$04], (arg0\Field3 - (552.0 * roomscale)), (arg0\Field4 + (240.0 * roomscale)), (arg0\Field5 - (656.0 * roomscale)), $00)
            entityparent(arg0\Field19[$04], arg0\Field2, $01)
            arg0\Field21[$00] = createdoor(arg0\Field0, (arg0\Field3 + (264.0 * roomscale)), 0.0, (arg0\Field5 + (656.0 * roomscale)), 90.0, arg0, $01, $03, $00, "", $00)
            arg0\Field21[$00]\Field21 = $00
            arg0\Field21[$00]\Field5 = $01
            positionentity(arg0\Field21[$00]\Field3[$00], (entityx(arg0\Field21[$00]\Field3[$00], $01) + 0.031), entityy(arg0\Field21[$00]\Field3[$00], $01), entityz(arg0\Field21[$00]\Field3[$00], $01), $01)
            positionentity(arg0\Field21[$00]\Field3[$01], (entityx(arg0\Field21[$00]\Field3[$01], $01) - 0.031), entityy(arg0\Field21[$00]\Field3[$01], $01), entityz(arg0\Field21[$00]\Field3[$01], $01), $01)
            arg0\Field21[$02] = createdoor(arg0\Field0, (arg0\Field3 - (264.0 * roomscale)), 0.0, (arg0\Field5 - (656.0 * roomscale)), 90.0, arg0, $01, $03, $00, "", $00)
            arg0\Field21[$02]\Field21 = $00
            arg0\Field21[$02]\Field5 = $01
            positionentity(arg0\Field21[$02]\Field3[$00], (entityx(arg0\Field21[$02]\Field3[$00], $01) + 0.031), entityy(arg0\Field21[$02]\Field3[$00], $01), entityz(arg0\Field21[$02]\Field3[$00], $01), $01)
            positionentity(arg0\Field21[$02]\Field3[$01], (entityx(arg0\Field21[$02]\Field3[$01], $01) - 0.031), entityy(arg0\Field21[$02]\Field3[$01], $01), entityz(arg0\Field21[$02]\Field3[$01], $01), $01)
            local18 = ((accesscode * $03) Mod $2710)
            If (local18 < $3E8) Then
                local18 = (local18 + $3E8)
            EndIf
            local0 = createdoor($00, arg0\Field3, arg0\Field4, arg0\Field5, 0.0, arg0, $00, $01, $00, (Str local18), $00)
            positionentity(local0\Field3[$00], (arg0\Field3 + (230.0 * roomscale)), (arg0\Field4 + 0.7), (arg0\Field5 - (384.0 * roomscale)), $01)
            rotateentity(local0\Field3[$00], 0.0, -90.0, 0.0, $01)
            positionentity(local0\Field3[$01], (arg0\Field3 - (230.0 * roomscale)), (arg0\Field4 + 0.7), (arg0\Field5 + (384.0 * roomscale)), $01)
            rotateentity(local0\Field3[$01], 0.0, 90.0, 0.0, $01)
            local3 = createdecal($00, (arg0\Field3 + (64.0 * roomscale)), 0.005, (arg0\Field5 + (144.0 * roomscale)), 90.0, (Float rand($168, $01)), 0.0)
            entityparent(local3\Field0, arg0\Field2, $01)
            local6 = createitem("Scorched Note", "paper", (arg0\Field3 + (64.0 * roomscale)), (arg0\Field4 + (144.0 * roomscale)), (arg0\Field5 - (384.0 * roomscale)), $00, $00, $00, 1.0, $00)
            entityparent(local6\Field1, arg0\Field2, $01)
        Case "room008"
            arg0\Field19[$00] = createpivot($00)
            positionentity(arg0\Field19[$00], (arg0\Field3 + (292.0 * roomscale)), (arg0\Field4 - (4985.0 * roomscale)), (arg0\Field5 + (516.0 * roomscale)), $00)
            entityparent(arg0\Field19[$00], arg0\Field2, $01)
            arg0\Field19[$01] = loadmesh_strict(scpmodding_processfilepath("GFX\map\room008_2.b3d"), $00)
            scaleentity(arg0\Field19[$01], roomscale, roomscale, roomscale, $00)
            positionentity(arg0\Field19[$01], (arg0\Field3 + (292.0 * roomscale)), (arg0\Field4 - (4954.0 * roomscale)), (arg0\Field5 + (576.0 * roomscale)), $00)
            rotateentity(arg0\Field19[$01], 89.0, 0.0, 0.0, $01)
            entityparent(arg0\Field19[$01], arg0\Field2, $01)
            arg0\Field20[$00] = arg0\Field19[$01]
            local16 = loadtexture_strict(scpmodding_processfilepath("GFX\map\glass.png"), $03)
            arg0\Field19[$02] = createsprite($00)
            entitytexture(arg0\Field19[$02], local16, $00, $00)
            spriteviewmode(arg0\Field19[$02], $02)
            scalesprite(arg0\Field19[$02], ((256.0 * roomscale) * 0.5), ((194.0 * roomscale) * 0.5))
            positionentity(arg0\Field19[$02], (arg0\Field3 - (176.0 * roomscale)), (arg0\Field4 - (4881.0 * roomscale)), (arg0\Field5 + (448.0 * roomscale)), $00)
            turnentity(arg0\Field19[$02], 0.0, 90.0, 0.0, $00)
            freetexture(local16)
            entityparent(arg0\Field19[$02], arg0\Field2, $01)
            arg0\Field19[$03] = createpivot($00)
            positionentity(arg0\Field19[$03], (arg0\Field3 - (445.0 * roomscale)), (arg0\Field4 - (4985.0 * roomscale)), (arg0\Field5 + (544.0 * roomscale)), $00)
            entityparent(arg0\Field19[$03], arg0\Field2, $01)
            arg0\Field19[$04] = createpivot($00)
            positionentity(arg0\Field19[$04], (arg0\Field3 + (67.0 * roomscale)), (arg0\Field4 - (4985.0 * roomscale)), (arg0\Field5 + (464.0 * roomscale)), $00)
            entityparent(arg0\Field19[$04], arg0\Field2, $01)
            arg0\Field19[$05] = createsprite($00)
            positionentity(arg0\Field19[$05], (arg0\Field3 - (158.0 * roomscale)), (arg0\Field4 - (4737.0 * roomscale)), (arg0\Field5 + (298.0 * roomscale)), $00)
            scalesprite(arg0\Field19[$05], 0.02, 0.02)
            entitytexture(arg0\Field19[$05], at\Field3[$01], $00, $00)
            entityblend(arg0\Field19[$05], $03)
            hideentity(arg0\Field19[$05])
            entityparent(arg0\Field19[$05], arg0\Field2, $01)
            local0 = createdoor(arg0\Field0, (arg0\Field3 + (296.0 * roomscale)), (arg0\Field4 - (5105.0 * roomscale)), (arg0\Field5 - (672.0 * roomscale)), 180.0, arg0, $01, $00, $06, "", $00)
            local0\Field21 = $00
            positionentity(local0\Field3[$01], (arg0\Field3 + (164.0 * roomscale)), entityy(local0\Field3[$01], $01), entityz(local0\Field3[$01], $01), $01)
            freeentity(local0\Field3[$00])
            local0\Field3[$00] = $00
            freeentity(local0\Field1)
            local0\Field1 = $00
            arg0\Field21[$00] = local0
            local1 = createdoor(arg0\Field0, (arg0\Field3 + (296.0 * roomscale)), (arg0\Field4 - (5105.0 * roomscale)), (arg0\Field5 - (144.0 * roomscale)), 0.0, arg0, $00, $00, $00, "", $00)
            local1\Field21 = $00
            positionentity(local1\Field3[$00], (arg0\Field3 + (438.0 * roomscale)), entityy(local1\Field3[$00], $01), (arg0\Field5 - (480.0 * roomscale)), $01)
            rotateentity(local1\Field3[$00], 0.0, -90.0, 0.0, $01)
            positionentity(local1\Field3[$01], (arg0\Field3 + (164.0 * roomscale)), entityy(local1\Field3[$00], $01), (arg0\Field5 - (134.0 * roomscale)), $01)
            freeentity(local1\Field1)
            local1\Field1 = $00
            arg0\Field21[$01] = local1
            local0\Field22 = local1
            local1\Field22 = local0
            local0 = createdoor(arg0\Field0, (arg0\Field3 - (384.0 * roomscale)), (arg0\Field4 - (5105.0 * roomscale)), (arg0\Field5 - (672.0 * roomscale)), 0.0, arg0, $00, $00, $06, "", $00)
            local0\Field21 = $00
            local0\Field4 = $01
            arg0\Field21[$02] = local0
            arg0\Field21[$03] = createdoor(arg0\Field0, (arg0\Field3 + (448.0 * roomscale)), arg0\Field4, arg0\Field5, 90.0, arg0, $00, $03, $00, "", $00)
            arg0\Field21[$03]\Field21 = $00
            arg0\Field21[$03]\Field5 = $01
            arg0\Field21[$04] = createdoor(arg0\Field0, (arg0\Field3 + (800.0 * roomscale)), (arg0\Field4 - (5105.0 * roomscale)), (arg0\Field5 - (287.0 * roomscale)), 90.0, arg0, $00, $03, $00, "", $00)
            arg0\Field21[$04]\Field21 = $00
            arg0\Field21[$00]\Field5 = $01
            local6 = createitem("Hazmat Suit", "hazmatsuit", (arg0\Field3 - (76.0 * roomscale)), (arg0\Field4 - (4895.0 * roomscale)), (arg0\Field5 - (396.0 * roomscale)), $00, $00, $00, 1.0, $00)
            entityparent(local6\Field1, arg0\Field2, $01)
            rotateentity(local6\Field1, 0.0, 90.0, 0.0, $00)
            local6 = createitem("Document SCP-008", "paper", (arg0\Field3 - (545.0 * roomscale)), (arg0\Field4 - (4895.0 * roomscale)), (arg0\Field5 + (368.0 * roomscale)), $00, $00, $00, 1.0, $00)
            entityparent(local6\Field1, arg0\Field2, $01)
            rotateentity(local6\Field1, 0.0, 0.0, 0.0, $00)
            arg0\Field19[$06] = createpivot($00)
            positionentity(arg0\Field19[$06], (arg0\Field3 + (160.0 * roomscale)), (arg0\Field4 + (670.0 * roomscale)), (arg0\Field5 - (384.0 * roomscale)), $00)
            entityparent(arg0\Field19[$06], arg0\Field2, $01)
            arg0\Field19[$07] = createpivot($00)
            positionentity(arg0\Field19[$07], arg0\Field3, (arg0\Field4 + (672.0 * roomscale)), (arg0\Field5 + (350.0 * roomscale)), $00)
            entityparent(arg0\Field19[$07], arg0\Field2, $01)
            arg0\Field19[$08] = createpivot($00)
            positionentity(arg0\Field19[$08], (arg0\Field3 + (708.0 * roomscale)), (arg0\Field4 + (240.0 * roomscale)), arg0\Field5, $00)
            entityparent(arg0\Field19[$08], arg0\Field2, $01)
            arg0\Field19[$09] = createpivot($00)
            positionentity(arg0\Field19[$09], (arg0\Field3 + (1058.0 * roomscale)), (arg0\Field4 - (4865.0 * roomscale)), (arg0\Field5 - (287.0 * roomscale)), $00)
            entityparent(arg0\Field19[$09], arg0\Field2, $01)
            local2 = createsecuritycam((arg0\Field3 + (666.0 * roomscale)), (arg0\Field4 - (4654.0 * roomscale)), (arg0\Field5 + (755.0 * roomscale)), arg0, $00)
            local2\Field11 = 135.0
            local2\Field12 = 45.0
            turnentity(local2\Field3, 20.0, 0.0, 0.0, $00)
        Case "room035"
            local0 = createdoor(arg0\Field0, (arg0\Field3 - (296.0 * roomscale)), 0.0, (arg0\Field5 - (672.0 * roomscale)), 180.0, arg0, $01, $00, $07, "", $00)
            local0\Field21 = $00
            local0\Field4 = $01
            arg0\Field21[$00] = local0
            positionentity(local0\Field3[$01], (arg0\Field3 - (164.0 * roomscale)), entityy(local0\Field3[$01], $01), entityz(local0\Field3[$01], $01), $01)
            freeentity(local0\Field3[$00])
            local0\Field3[$00] = $00
            freeentity(local0\Field1)
            local0\Field1 = $00
            local1 = createdoor(arg0\Field0, (arg0\Field3 - (296.0 * roomscale)), 0.0, (arg0\Field5 - (144.0 * roomscale)), 0.0, arg0, $00, $00, $00, "", $00)
            local1\Field21 = $00
            local1\Field4 = $01
            arg0\Field21[$01] = local1
            positionentity(local1\Field3[$00], (arg0\Field3 - (438.0 * roomscale)), entityy(local1\Field3[$00], $01), (arg0\Field5 - (480.0 * roomscale)), $01)
            rotateentity(local1\Field3[$00], 0.0, 90.0, 0.0, $01)
            freeentity(local1\Field3[$01])
            local1\Field3[$01] = $00
            freeentity(local1\Field1)
            local1\Field1 = $00
            arg0\Field21[$02] = createdoor(arg0\Field0, (arg0\Field3 + (384.0 * roomscale)), 0.0, (arg0\Field5 - (672.0 * roomscale)), 180.0, arg0, $00, $00, $07, "", $00)
            arg0\Field21[$02]\Field21 = $00
            arg0\Field21[$03] = createdoor($00, (arg0\Field3 + (768.0 * roomscale)), 0.0, (arg0\Field5 + (512.0 * roomscale)), 90.0, arg0, $00, $00, $00, "5731", $00)
            arg0\Field21[$03]\Field21 = $00
            local0\Field22 = local1
            local1\Field22 = local0
            For local7 = $00 To $01 Step $01
                arg0\Field19[(local7 Shl $01)] = copyentity(local11\Field5[$00], $00)
                arg0\Field19[((local7 Shl $01) + $01)] = copyentity(local11\Field5[$01], $00)
                arg0\Field20[local7] = arg0\Field19[((local7 Shl $01) + $01)]
                For local17 = $00 To $01 Step $01
                    scaleentity(arg0\Field19[((local7 Shl $01) + local17)], 0.04, 0.04, 0.04, $00)
                    positionentity(arg0\Field19[((local7 Shl $01) + local17)], (arg0\Field3 + (210.0 * roomscale)), (arg0\Field4 + (224.0 * roomscale)), (arg0\Field5 - ((Float ($D0 - (local7 * $4C))) * roomscale)), $01)
                    entityparent(arg0\Field19[((local7 Shl $01) + local17)], arg0\Field2, $01)
                Next
                rotateentity(arg0\Field19[(local7 Shl $01)], 0.0, -270.0, 0.0, $00)
                rotateentity(arg0\Field19[((local7 Shl $01) + $01)], -80.0, -90.0, 0.0, $00)
                entitypickmode(arg0\Field19[((local7 Shl $01) + $01)], $01, $00)
                entityradius(arg0\Field19[((local7 Shl $01) + $01)], 0.1, 0.0)
            Next
            arg0\Field19[$03] = createpivot($00)
            positionentity(arg0\Field19[$03], (arg0\Field3 + (456.0 * roomscale)), 0.5, (arg0\Field5 + (400.0 * roomscale)), $00)
            arg0\Field19[$04] = createpivot($00)
            positionentity(arg0\Field19[$04], (arg0\Field3 - (576.0 * roomscale)), 0.5, (arg0\Field5 + (640.0 * roomscale)), $00)
            For local7 = $03 To $04 Step $01
                entityparent(arg0\Field19[local7], arg0\Field2, $01)
            Next
            For local7 = $00 To $01 Step $01
                local15 = createemitter((arg0\Field3 - (272.0 * roomscale)), (arg0\Field4 + 10.0), (arg0\Field5 + ((624.0 - (Float (local7 Shl $09))) * roomscale)), $00)
                turnentity(local15\Field0, 90.0, 0.0, 0.0, $01)
                entityparent(local15\Field0, arg0\Field2, $01)
                local15\Field10 = 15.0
                local15\Field9 = 0.05
                local15\Field11 = 0.007
                local15\Field12 = -0.006
                local15\Field4 = -0.24
                arg0\Field19[($05 + local7)] = local15\Field0
            Next
            arg0\Field19[$07] = createpivot($00)
            positionentity(arg0\Field19[$07], (arg0\Field3 - (720.0 * roomscale)), (arg0\Field4 + 0.5), (arg0\Field5 + (880.0 * roomscale)), $00)
            arg0\Field19[$08] = createpivot($00)
            positionentity(arg0\Field19[$08], (arg0\Field3 + (176.0 * roomscale)), (arg0\Field4 + 0.5), (arg0\Field5 - (144.0 * roomscale)), $00)
            For local7 = $07 To $08 Step $01
                entityparent(arg0\Field19[local7], arg0\Field2, $01)
            Next
            local6 = createitem("SCP-035 Addendum", "paper", (arg0\Field3 + (248.0 * roomscale)), (arg0\Field4 + (220.0 * roomscale)), (arg0\Field5 + (576.0 * roomscale)), $00, $00, $00, 1.0, $00)
            entityparent(local6\Field1, arg0\Field2, $01)
            local6 = createitem("Radio Transceiver", "radio", (arg0\Field3 - (544.0 * roomscale)), (arg0\Field4 + 0.5), (arg0\Field5 + (704.0 * roomscale)), $00, $00, $00, 1.0, $00)
            entityparent(local6\Field1, arg0\Field2, $01)
            local6 = createitem("SCP-500-01", "scp500pill", (arg0\Field3 + (1168.0 * roomscale)), (arg0\Field4 + (250.0 * roomscale)), (arg0\Field5 + (576.0 * roomscale)), $00, $00, $00, 1.0, $00)
            entityparent(local6\Field1, arg0\Field2, $01)
            local6 = createitem("Metal Panel", "scp148", (arg0\Field3 - (360.0 * roomscale)), (arg0\Field4 + 0.5), (arg0\Field5 + (644.0 * roomscale)), $00, $00, $00, 1.0, $00)
            entityparent(local6\Field1, arg0\Field2, $01)
            local6 = createitem("Document SCP-035", "paper", (arg0\Field3 + (1168.0 * roomscale)), (arg0\Field4 + (100.0 * roomscale)), (arg0\Field5 + (408.0 * roomscale)), $00, $00, $00, 1.0, $00)
            entityparent(local6\Field1, arg0\Field2, $01)
        Case "room513"
            local0 = createdoor(arg0\Field0, (arg0\Field3 - (704.0 * roomscale)), arg0\Field4, (arg0\Field5 + (304.0 * roomscale)), 0.0, arg0, $00, $00, $04, "", $00)
            local0\Field21 = $00
            positionentity(local0\Field3[$00], entityx(local0\Field3[$00], $01), entityy(local0\Field3[$00], $01), (entityz(local0\Field3[$00], $01) + 0.061), $01)
            positionentity(local0\Field3[$01], entityx(local0\Field3[$01], $01), entityy(local0\Field3[$01], $01), (entityz(local0\Field3[$01], $01) - 0.031), $01)
            local2 = createsecuritycam((arg0\Field3 - (312.0 * roomscale)), (arg0\Field4 + (414.0 * roomscale)), (arg0\Field5 + (656.0 * roomscale)), arg0, $00)
            local2\Field20 = $01
            local6 = createitem("SCP-513", "scp513", (arg0\Field3 - (32.0 * roomscale)), (arg0\Field4 + (196.0 * roomscale)), (arg0\Field5 + (688.0 * roomscale)), $00, $00, $00, 1.0, $00)
            entityparent(local6\Field1, arg0\Field2, $01)
            local6 = createitem("Blood-stained Note", "paper", (arg0\Field3 + (736.0 * roomscale)), (arg0\Field4 + 1.0), (arg0\Field5 + (48.0 * roomscale)), $00, $00, $00, 1.0, $00)
            entityparent(local6\Field1, arg0\Field2, $01)
            local6 = createitem("Document SCP-513", "paper", (arg0\Field3 - (480.0 * roomscale)), (arg0\Field4 + (104.0 * roomscale)), (arg0\Field5 - (176.0 * roomscale)), $00, $00, $00, 1.0, $00)
            entityparent(local6\Field1, arg0\Field2, $01)
        Case "room966"
            local0 = createdoor(arg0\Field0, (arg0\Field3 - (400.0 * roomscale)), 0.0, arg0\Field5, -90.0, arg0, $00, $00, $05, "", $00)
            local0 = createdoor(arg0\Field0, arg0\Field3, 0.0, (arg0\Field5 - (480.0 * roomscale)), 180.0, arg0, $00, $00, $05, "", $00)
            local2 = createsecuritycam((arg0\Field3 - (312.0 * roomscale)), (arg0\Field4 + (452.0 * roomscale)), (arg0\Field5 + (644.0 * roomscale)), arg0, $00)
            local2\Field11 = 225.0
            local2\Field12 = 45.0
            turnentity(local2\Field3, 20.0, 0.0, 0.0, $00)
            arg0\Field19[$00] = createpivot($00)
            positionentity(arg0\Field19[$00], arg0\Field3, (arg0\Field4 + 0.5), (arg0\Field5 + (512.0 * roomscale)), $00)
            entityparent(arg0\Field19[$00], arg0\Field2, $01)
            arg0\Field19[$01] = createpivot($00)
            positionentity(arg0\Field19[$01], (arg0\Field3 + (64.0 * roomscale)), (arg0\Field4 + 0.5), (arg0\Field5 - (640.0 * roomscale)), $00)
            entityparent(arg0\Field19[$01], arg0\Field2, $01)
            arg0\Field19[$02] = createpivot($00)
            positionentity(arg0\Field19[$02], arg0\Field3, (arg0\Field4 + 0.5), arg0\Field5, $00)
            entityparent(arg0\Field19[$02], arg0\Field2, $01)
            arg0\Field19[$03] = createpivot($00)
            positionentity(arg0\Field19[$03], (arg0\Field3 + (320.0 * roomscale)), (arg0\Field4 + 0.5), (arg0\Field5 + (704.0 * roomscale)), $00)
            entityparent(arg0\Field19[$03], arg0\Field2, $01)
            local6 = createitem("Night Vision Goggles", "nvgoggles", (arg0\Field3 + (320.0 * roomscale)), (arg0\Field4 + 0.5), (arg0\Field5 + (704.0 * roomscale)), $00, $00, $00, 1.0, $00)
            entityparent(local6\Field1, arg0\Field2, $01)
            local6\Field13 = 300.0
        Case "room3storage"
            arg0\Field19[$00] = createpivot($00)
            positionentity(arg0\Field19[$00], arg0\Field3, (arg0\Field4 + (240.0 * roomscale)), (arg0\Field5 + (752.0 * roomscale)), $00)
            entityparent(arg0\Field19[$00], arg0\Field2, $01)
            arg0\Field19[$01] = createpivot($00)
            positionentity(arg0\Field19[$01], (arg0\Field3 + (5840.0 * roomscale)), (arg0\Field4 - (5392.0 * roomscale)), (arg0\Field5 + (1360.0 * roomscale)), $00)
            entityparent(arg0\Field19[$01], arg0\Field2, $01)
            arg0\Field19[$02] = createpivot($00)
            positionentity(arg0\Field19[$02], (arg0\Field3 + (608.0 * roomscale)), (arg0\Field4 + (240.0 * roomscale)), (arg0\Field5 - (624.0 * roomscale)), $00)
            entityparent(arg0\Field19[$02], arg0\Field2, $01)
            arg0\Field19[$03] = createpivot($00)
            positionentity(arg0\Field19[$03], (arg0\Field3 - (456.0 * roomscale)), (arg0\Field4 - (5392.0 * roomscale)), (arg0\Field5 - (1136.0 * roomscale)), $00)
            entityparent(arg0\Field19[$03], arg0\Field2, $01)
            arg0\Field19[$04] = createpivot($00)
            positionentity(arg0\Field19[$04], (arg0\Field3 + (2128.0 * roomscale)), (arg0\Field4 - (5550.0 * roomscale)), (arg0\Field5 + (2048.0 * roomscale)), $00)
            entityparent(arg0\Field19[$04], arg0\Field2, $01)
            arg0\Field19[$05] = createpivot($00)
            positionentity(arg0\Field19[$05], (arg0\Field3 + (2128.0 * roomscale)), (arg0\Field4 - (5550.0 * roomscale)), (arg0\Field5 - (1136.0 * roomscale)), $00)
            entityparent(arg0\Field19[$05], arg0\Field2, $01)
            arg0\Field19[$06] = createpivot($00)
            positionentity(arg0\Field19[$06], (arg0\Field3 + (3824.0 * roomscale)), (arg0\Field4 - (5550.0 * roomscale)), (arg0\Field5 - (1168.0 * roomscale)), $00)
            entityparent(arg0\Field19[$06], arg0\Field2, $01)
            arg0\Field19[$07] = createpivot($00)
            positionentity(arg0\Field19[$07], (arg0\Field3 + (3760.0 * roomscale)), (arg0\Field4 - (5550.0 * roomscale)), (arg0\Field5 + (2048.0 * roomscale)), $00)
            entityparent(arg0\Field19[$07], arg0\Field2, $01)
            arg0\Field19[$08] = createpivot($00)
            positionentity(arg0\Field19[$08], (arg0\Field3 + (4848.0 * roomscale)), (arg0\Field4 - (5550.0 * roomscale)), (arg0\Field5 + (112.0 * roomscale)), $00)
            entityparent(arg0\Field19[$08], arg0\Field2, $01)
            arg0\Field19[$09] = createpivot($00)
            positionentity(arg0\Field19[$09], (arg0\Field3 + (592.0 * roomscale)), (arg0\Field4 - (5550.0 * roomscale)), (arg0\Field5 + (6352.0 * roomscale)), $00)
            entityparent(arg0\Field19[$09], arg0\Field2, $01)
            arg0\Field19[$0A] = createpivot($00)
            positionentity(arg0\Field19[$0A], (arg0\Field3 + (2928.0 * roomscale)), (arg0\Field4 - (5550.0 * roomscale)), (arg0\Field5 + (6352.0 * roomscale)), $00)
            entityparent(arg0\Field19[$0A], arg0\Field2, $01)
            arg0\Field19[$0B] = createpivot($00)
            positionentity(arg0\Field19[$0B], (arg0\Field3 + (2928.0 * roomscale)), (arg0\Field4 - (5550.0 * roomscale)), (arg0\Field5 + (5200.0 * roomscale)), $00)
            entityparent(arg0\Field19[$0B], arg0\Field2, $01)
            arg0\Field19[$0C] = createpivot($00)
            positionentity(arg0\Field19[$0C], (arg0\Field3 + (592.0 * roomscale)), (arg0\Field4 - (5550.0 * roomscale)), (arg0\Field5 + (5200.0 * roomscale)), $00)
            entityparent(arg0\Field19[$0C], arg0\Field2, $01)
            arg0\Field19[$0D] = createpivot($00)
            positionentity(arg0\Field19[$0D], (arg0\Field3 + (1136.0 * roomscale)), (arg0\Field4 - (5550.0 * roomscale)), (arg0\Field5 + (2944.0 * roomscale)), $00)
            entityparent(arg0\Field19[$0D], arg0\Field2, $01)
            arg0\Field19[$0E] = createpivot($00)
            positionentity(arg0\Field19[$0E], (arg0\Field3 + (1104.0 * roomscale)), (arg0\Field4 - (5550.0 * roomscale)), (arg0\Field5 + (1184.0 * roomscale)), $00)
            entityparent(arg0\Field19[$0E], arg0\Field2, $01)
            arg0\Field19[$0F] = createpivot($00)
            positionentity(arg0\Field19[$0F], (arg0\Field3 - (464.0 * roomscale)), (arg0\Field4 - (5550.0 * roomscale)), (arg0\Field5 + (1216.0 * roomscale)), $00)
            entityparent(arg0\Field19[$0F], arg0\Field2, $01)
            arg0\Field19[$10] = createpivot($00)
            positionentity(arg0\Field19[$10], (arg0\Field3 - (432.0 * roomscale)), (arg0\Field4 - (5550.0 * roomscale)), (arg0\Field5 + (2976.0 * roomscale)), $00)
            entityparent(arg0\Field19[$10], arg0\Field2, $01)
            If (arg0\Field19[$14] = $00) Then
                arg0\Field19[$14] = loadmesh_strict(scpmodding_processfilepath("GFX\map\room3storage_hb.b3d"), arg0\Field2)
            EndIf
            entitypickmode(arg0\Field19[$14], $02, $01)
            entitytype(arg0\Field19[$14], $01, $00)
            entityalpha(arg0\Field19[$14], 0.0)
            arg0\Field21[$00] = createdoor(arg0\Field0, arg0\Field3, arg0\Field4, (arg0\Field5 + (448.0 * roomscale)), 0.0, arg0, $01, $03, $00, "", $00)
            arg0\Field21[$00]\Field21 = $00
            arg0\Field21[$00]\Field5 = $01
            arg0\Field21[$01] = createdoor(arg0\Field0, (arg0\Field3 + (5840.0 * roomscale)), (arg0\Field4 - (5632.0 * roomscale)), (arg0\Field5 + (1048.0 * roomscale)), 0.0, arg0, $00, $03, $00, "", $00)
            arg0\Field21[$01]\Field21 = $00
            arg0\Field21[$01]\Field5 = $00
            positionentity(arg0\Field21[$01]\Field3[$00], entityx(arg0\Field21[$01]\Field3[$00], $01), entityy(arg0\Field21[$01]\Field3[$00], $01), (entityz(arg0\Field21[$01]\Field3[$00], $01) - 0.031), $01)
            positionentity(arg0\Field21[$01]\Field3[$01], entityx(arg0\Field21[$01]\Field3[$01], $01), entityy(arg0\Field21[$01]\Field3[$01], $01), (entityz(arg0\Field21[$01]\Field3[$01], $01) + 0.031), $01)
            arg0\Field21[$02] = createdoor(arg0\Field0, (arg0\Field3 + (608.0 * roomscale)), arg0\Field4, (arg0\Field5 - (313.0 * roomscale)), 0.0, arg0, $01, $03, $00, "", $00)
            arg0\Field21[$02]\Field21 = $00
            arg0\Field21[$02]\Field5 = $01
            positionentity(arg0\Field21[$02]\Field3[$00], entityx(arg0\Field21[$02]\Field3[$00], $01), entityy(arg0\Field21[$02]\Field3[$00], $01), (entityz(arg0\Field21[$02]\Field3[$00], $01) - 0.03), $01)
            positionentity(arg0\Field21[$02]\Field3[$01], entityx(arg0\Field21[$02]\Field3[$01], $01), entityy(arg0\Field21[$02]\Field3[$01], $01), (entityz(arg0\Field21[$02]\Field3[$01], $01) + 0.03), $01)
            arg0\Field21[$03] = createdoor(arg0\Field0, (arg0\Field3 - (456.0 * roomscale)), (arg0\Field4 - (5632.0 * roomscale)), (arg0\Field5 - (824.0 * roomscale)), 0.0, arg0, $00, $03, $00, "", $00)
            arg0\Field21[$03]\Field21 = $00
            arg0\Field21[$03]\Field5 = $00
            positionentity(arg0\Field21[$03]\Field3[$00], entityx(arg0\Field21[$03]\Field3[$00], $01), entityy(arg0\Field21[$03]\Field3[$00], $01), (entityz(arg0\Field21[$03]\Field3[$00], $01) - 0.031), $01)
            positionentity(arg0\Field21[$03]\Field3[$01], entityx(arg0\Field21[$03]\Field3[$01], $01), entityy(arg0\Field21[$03]\Field3[$01], $01), (entityz(arg0\Field21[$03]\Field3[$01], $01) + 0.031), $01)
            local15 = createemitter((arg0\Field3 + (5218.0 * roomscale)), (arg0\Field4 - (5584.0 * roomscale)), (arg0\Field5 - (600.0 * roomscale)), $00)
            turnentity(local15\Field0, 20.0, -100.0, 0.0, $01)
            entityparent(local15\Field0, arg0\Field2, $01)
            local15\Field7 = arg0
            local15\Field10 = 15.0
            local15\Field9 = 0.03
            local15\Field11 = 0.01
            local15\Field12 = -0.006
            local15\Field4 = -0.2
            Select rand($03, $01)
                Case $01
                    local20 = 2312.0
                    local21 = -952.0
                Case $02
                    local20 = 3032.0
                    local21 = 1288.0
                Case $03
                    local20 = 2824.0
                    local21 = 2808.0
            End Select
            local6 = createitem("Black Severed Hand", "hand2", (arg0\Field3 + (local20 * roomscale)), ((arg0\Field4 - (5596.0 * roomscale)) + 1.0), (arg0\Field5 + (local21 * roomscale)), $00, $00, $00, 1.0, $00)
            entityparent(local6\Field1, arg0\Field2, $01)
            local6 = createitem("Night Vision Goggles", "nvgoggles", (arg0\Field3 + (1936.0 * roomscale)), (arg0\Field4 - (5496.0 * roomscale)), (arg0\Field5 - (944.0 * roomscale)), $00, $00, $00, 1.0, $00)
            entityparent(local6\Field1, arg0\Field2, $01)
            local6\Field13 = 450.0
            local3 = createdecal($03, (arg0\Field3 + (local20 * roomscale)), ((arg0\Field4 - (5632.0 * roomscale)) + 0.01), (arg0\Field5 + (local21 * roomscale)), 90.0, rnd(360.0, 0.0), 0.0)
            local3\Field2 = 0.5
            scalesprite(local3\Field0, local3\Field2, local3\Field2)
            entityparent(local3\Field0, arg0\Field2, $01)
            For local17 = $0A To $0B Step $01
                arg0\Field19[(local17 Shl $01)] = copyentity(local11\Field5[$00], $00)
                arg0\Field19[((local17 Shl $01) + $01)] = copyentity(local11\Field5[$01], $00)
                arg0\Field20[(local17 - $0A)] = arg0\Field19[((local17 Shl $01) + $01)]
                For local7 = $00 To $01 Step $01
                    scaleentity(arg0\Field19[((local17 Shl $01) + local7)], 0.04, 0.04, 0.04, $00)
                    If (local17 = $0A) Then
                        positionentity(arg0\Field19[((local17 Shl $01) + local7)], (arg0\Field3 + (3095.5 * roomscale)), (arg0\Field4 - (5461.0 * roomscale)), (arg0\Field5 + (6568.0 * roomscale)), $01)
                    Else
                        positionentity(arg0\Field19[((local17 Shl $01) + local7)], (arg0\Field3 + (1215.5 * roomscale)), (arg0\Field4 - (5461.0 * roomscale)), (arg0\Field5 + (3164.0 * roomscale)), $01)
                    EndIf
                    entityparent(arg0\Field19[((local17 Shl $01) + local7)], arg0\Field2, $01)
                Next
                rotateentity(arg0\Field19[(local17 Shl $01)], 0.0, 0.0, 0.0, $00)
                rotateentity(arg0\Field19[((local17 Shl $01) + $01)], -10.0, -180.0, 0.0, $00)
                entitypickmode(arg0\Field19[((local17 Shl $01) + $01)], $01, $00)
                entityradius(arg0\Field19[((local17 Shl $01) + $01)], 0.1, 0.0)
            Next
            arg0\Field21[$04] = createdoor(arg0\Field0, (arg0\Field3 + (56.0 * roomscale)), (arg0\Field4 - (5632.0 * roomscale)), (arg0\Field5 + (6344.0 * roomscale)), 90.0, arg0, $00, $02, $00, "", $00)
            arg0\Field21[$04]\Field21 = $00
            arg0\Field21[$04]\Field5 = $00
            For local7 = $00 To $01 Step $01
                freeentity(arg0\Field21[$04]\Field3[local7])
                arg0\Field21[$04]\Field3[local7] = $00
            Next
            local0 = createdoor(arg0\Field0, (arg0\Field3 + (1157.0 * roomscale)), (arg0\Field4 - (5632.0 * roomscale)), (arg0\Field5 + (660.0 * roomscale)), 0.0, arg0, $00, $02, $00, "", $00)
            local0\Field4 = $01
            local0\Field5 = $00
            local0\Field21 = $00
            For local7 = $00 To $01 Step $01
                freeentity(local0\Field3[local7])
                local0\Field3[local7] = $00
            Next
            local0 = createdoor(arg0\Field0, (arg0\Field3 + (234.0 * roomscale)), (arg0\Field4 - (5632.0 * roomscale)), (arg0\Field5 + (5239.0 * roomscale)), 90.0, arg0, $00, $02, $00, "", $00)
            local0\Field4 = $01
            local0\Field5 = $00
            local0\Field21 = $00
            For local7 = $00 To $01 Step $01
                freeentity(local0\Field3[local7])
                local0\Field3[local7] = $00
            Next
            local0 = createdoor(arg0\Field0, (arg0\Field3 + (3446.0 * roomscale)), (arg0\Field4 - (5632.0 * roomscale)), (arg0\Field5 + (6369.0 * roomscale)), 90.0, arg0, $00, $02, $00, "", $00)
            local0\Field4 = $01
            local0\Field5 = $00
            local0\Field21 = $00
            For local7 = $00 To $01 Step $01
                freeentity(local0\Field3[local7])
                local0\Field3[local7] = $00
            Next
        Case "room049"
            arg0\Field19[$00] = createpivot($00)
            positionentity(arg0\Field19[$00], (arg0\Field3 + (640.0 * roomscale)), (arg0\Field4 + (240.0 * roomscale)), (arg0\Field5 + (656.0 * roomscale)), $00)
            arg0\Field19[$01] = createpivot($00)
            positionentity(arg0\Field19[$01], (arg0\Field3 + (3211.0 * roomscale)), (arg0\Field4 - (3280.0 * roomscale)), (arg0\Field5 + (1824.0 * roomscale)), $00)
            arg0\Field19[$02] = createpivot($00)
            positionentity(arg0\Field19[$02], (arg0\Field3 - (672.0 * roomscale)), (arg0\Field4 + (240.0 * roomscale)), (arg0\Field5 - (93.0 * roomscale)), $00)
            arg0\Field19[$03] = createpivot($00)
            positionentity(arg0\Field19[$03], (arg0\Field3 - (2766.0 * roomscale)), (arg0\Field4 - (3280.0 * roomscale)), (arg0\Field5 - (1277.0 * roomscale)), $00)
            arg0\Field19[$04] = createpivot($00)
            positionentity(arg0\Field19[$04], (arg0\Field3 + (528.0 * roomscale)), (arg0\Field4 - (3440.0 * roomscale)), (arg0\Field5 + (96.0 * roomscale)), $00)
            arg0\Field19[$05] = createpivot($00)
            positionentity(arg0\Field19[$05], (arg0\Field3 + (64.0 * roomscale)), (arg0\Field4 - (3440.0 * roomscale)), (arg0\Field5 - (1000.0 * roomscale)), $00)
            For local7 = $00 To $05 Step $01
                entityparent(arg0\Field19[local7], arg0\Field2, $01)
            Next
            For local17 = $00 To $01 Step $01
                arg0\Field19[((local17 Shl $01) + $06)] = copyentity(local11\Field5[$00], $00)
                arg0\Field19[((local17 Shl $01) + $07)] = copyentity(local11\Field5[$01], $00)
                arg0\Field20[local17] = arg0\Field19[((local17 Shl $01) + $07)]
                For local7 = $00 To $01 Step $01
                    scaleentity(arg0\Field19[(((local17 Shl $01) + $06) + local7)], 0.03, 0.03, 0.03, $00)
                    Select local17
                        Case $00
                            positionentity(arg0\Field19[(((local17 Shl $01) + $06) + local7)], (arg0\Field3 + (852.0 * roomscale)), (arg0\Field4 - (3374.0 * roomscale)), (arg0\Field5 - (854.0 * roomscale)), $01)
                        Case $01
                            positionentity(arg0\Field19[(((local17 Shl $01) + $06) + local7)], (arg0\Field3 - (834.0 * roomscale)), (arg0\Field4 - (3400.0 * roomscale)), (arg0\Field5 + (1093.0 * roomscale)), $01)
                    End Select
                    entityparent(arg0\Field19[(((local17 Shl $01) + $06) + local7)], arg0\Field2, $01)
                Next
                rotateentity(arg0\Field19[((local17 Shl $01) + $06)], 0.0, (Float (((local17 = $00) * $5A) + $B4)), 0.0, $00)
                rotateentity(arg0\Field19[((local17 Shl $01) + $07)], (Float ($51 - ($5C * local17))), (Float ((local17 = $00) * $5A)), 0.0, $00)
                entitypickmode(arg0\Field19[((local17 Shl $01) + $07)], $01, $00)
                entityradius(arg0\Field19[((local17 Shl $01) + $07)], 0.1, 0.0)
            Next
            arg0\Field21[$00] = createdoor(arg0\Field0, (arg0\Field3 + (328.0 * roomscale)), arg0\Field4, (arg0\Field5 + (656.0 * roomscale)), 90.0, arg0, $01, $03, $00, "", $00)
            arg0\Field21[$00]\Field21 = $00
            arg0\Field21[$00]\Field5 = $01
            positionentity(arg0\Field21[$00]\Field3[$00], (entityx(arg0\Field21[$00]\Field3[$00], $01) + 0.03), entityy(arg0\Field21[$00]\Field3[$00], $01), entityz(arg0\Field21[$00]\Field3[$00], $01), $01)
            positionentity(arg0\Field21[$00]\Field3[$01], (entityx(arg0\Field21[$00]\Field3[$01], $01) - 0.03), entityy(arg0\Field21[$00]\Field3[$01], $01), entityz(arg0\Field21[$00]\Field3[$01], $01), $01)
            arg0\Field21[$01] = createdoor(arg0\Field0, (arg0\Field3 + (2908.0 * roomscale)), (arg0\Field4 - (3520.0 * roomscale)), (arg0\Field5 + (1824.0 * roomscale)), 90.0, arg0, $00, $03, $00, "", $00)
            arg0\Field21[$01]\Field21 = $00
            arg0\Field21[$01]\Field5 = $00
            positionentity(arg0\Field21[$01]\Field3[$00], (entityx(arg0\Field21[$01]\Field3[$00], $01) - 0.018), entityy(arg0\Field21[$01]\Field3[$01], $01), entityz(arg0\Field21[$01]\Field3[$00], $01), $01)
            positionentity(arg0\Field21[$01]\Field3[$01], (entityx(arg0\Field21[$01]\Field3[$01], $01) + 0.018), entityy(arg0\Field21[$01]\Field3[$01], $01), entityz(arg0\Field21[$01]\Field3[$01], $01), $01)
            arg0\Field21[$02] = createdoor(arg0\Field0, (arg0\Field3 - (672.0 * roomscale)), arg0\Field4, (arg0\Field5 - (408.0 * roomscale)), 0.0, arg0, $01, $03, $00, "", $00)
            arg0\Field21[$02]\Field21 = $00
            arg0\Field21[$02]\Field5 = $01
            positionentity(arg0\Field21[$02]\Field3[$00], entityx(arg0\Field21[$02]\Field3[$00], $01), entityy(arg0\Field21[$02]\Field3[$01], $01), (entityz(arg0\Field21[$02]\Field3[$00], $01) - 0.03), $01)
            positionentity(arg0\Field21[$02]\Field3[$01], entityx(arg0\Field21[$02]\Field3[$01], $01), entityy(arg0\Field21[$02]\Field3[$01], $01), (entityz(arg0\Field21[$02]\Field3[$01], $01) + 0.03), $01)
            arg0\Field21[$03] = createdoor(arg0\Field0, (arg0\Field3 - (2766.0 * roomscale)), (arg0\Field4 - (3520.0 * roomscale)), (arg0\Field5 - (1592.0 * roomscale)), 0.0, arg0, $00, $03, $00, "", $00)
            arg0\Field21[$03]\Field21 = $00
            arg0\Field21[$03]\Field5 = $00
            positionentity(arg0\Field21[$03]\Field3[$00], entityx(arg0\Field21[$03]\Field3[$00], $01), entityy(arg0\Field21[$03]\Field3[$01], $01), (entityz(arg0\Field21[$03]\Field3[$00], $01) - 0.03), $01)
            positionentity(arg0\Field21[$03]\Field3[$01], entityx(arg0\Field21[$03]\Field3[$01], $01), entityy(arg0\Field21[$03]\Field3[$01], $01), (entityz(arg0\Field21[$03]\Field3[$01], $01) + 0.03), $01)
            arg0\Field21[$04] = createdoor(arg0\Field0, (arg0\Field3 + (272.0 * roomscale)), (arg0\Field4 - (3552.0 * roomscale)), (arg0\Field5 + (104.0 * roomscale)), 90.0, arg0, $00, $00, $00, "", $00)
            arg0\Field21[$04]\Field21 = $00
            arg0\Field21[$04]\Field5 = $01
            arg0\Field21[$04]\Field4 = $01
            arg0\Field21[$05] = createdoor(arg0\Field0, (arg0\Field3 + (264.0 * roomscale)), (arg0\Field4 - (3520.0 * roomscale)), (arg0\Field5 - (1824.0 * roomscale)), 90.0, arg0, $00, $00, $00, "", $00)
            arg0\Field21[$05]\Field21 = $00
            arg0\Field21[$05]\Field5 = $01
            arg0\Field21[$05]\Field4 = $01
            positionentity(arg0\Field21[$05]\Field3[$00], (entityx(arg0\Field21[$05]\Field3[$00], $01) - 0.03), entityy(arg0\Field21[$05]\Field3[$01], $01), entityz(arg0\Field21[$05]\Field3[$00], $01), $01)
            positionentity(arg0\Field21[$05]\Field3[$01], (entityx(arg0\Field21[$05]\Field3[$01], $01) + 0.03), entityy(arg0\Field21[$05]\Field3[$01], $01), entityz(arg0\Field21[$05]\Field3[$01], $01), $01)
            arg0\Field21[$06] = createdoor(arg0\Field0, (arg0\Field3 - (264.0 * roomscale)), (arg0\Field4 - (3520.0 * roomscale)), (arg0\Field5 + (1824.0 * roomscale)), 90.0, arg0, $00, $00, $00, "", $00)
            arg0\Field21[$06]\Field21 = $00
            arg0\Field21[$06]\Field5 = $01
            arg0\Field21[$06]\Field4 = $01
            positionentity(arg0\Field21[$06]\Field3[$00], (entityx(arg0\Field21[$06]\Field3[$00], $01) - 0.03), entityy(arg0\Field21[$06]\Field3[$01], $01), entityz(arg0\Field21[$06]\Field3[$00], $01), $01)
            positionentity(arg0\Field21[$06]\Field3[$01], (entityx(arg0\Field21[$06]\Field3[$01], $01) + 0.03), entityy(arg0\Field21[$06]\Field3[$01], $01), entityz(arg0\Field21[$06]\Field3[$01], $01), $01)
            local0 = createdoor($00, arg0\Field3, arg0\Field4, arg0\Field5, 0.0, arg0, $00, $02, $FFFFFFFE, "", $00)
            local0\Field21 = $00
            local6 = createitem("Document SCP-049", "paper", (arg0\Field3 - (608.0 * roomscale)), (arg0\Field4 - (3332.0 * roomscale)), (arg0\Field5 + (876.0 * roomscale)), $00, $00, $00, 1.0, $00)
            entityparent(local6\Field1, arg0\Field2, $01)
            local6 = createitem("Level 4 Key Card", "key4", (arg0\Field3 - (512.0 * roomscale)), (arg0\Field4 - (3412.0 * roomscale)), (arg0\Field5 + (864.0 * roomscale)), $00, $00, $00, 1.0, $00)
            entityparent(local6\Field1, arg0\Field2, $01)
            local6 = createitem("First Aid Kit", "firstaid", (arg0\Field3 + (385.0 * roomscale)), (arg0\Field4 - (3412.0 * roomscale)), (arg0\Field5 + (271.0 * roomscale)), $00, $00, $00, 1.0, $00)
            entityparent(local6\Field1, arg0\Field2, $01)
            local0 = createdoor(arg0\Field0, (arg0\Field3 - (272.0 * roomscale)), (arg0\Field4 - (3552.0 * roomscale)), (arg0\Field5 + (98.0 * roomscale)), 90.0, arg0, $01, $01, $00, "", $00)
            local0\Field21 = $00
            local0\Field5 = $01
            local0\Field24 = $00
            local0\Field4 = $01
            freeentity(local0\Field3[$00])
            local0\Field3[$00] = $00
            freeentity(local0\Field3[$01])
            local0\Field3[$01] = $00
            local0 = createdoor(arg0\Field0, (arg0\Field3 - (2990.0 * roomscale)), (arg0\Field4 - (3520.0 * roomscale)), (arg0\Field5 - (1824.0 * roomscale)), 90.0, arg0, $00, $02, $00, "", $00)
            local0\Field4 = $01
            local0\Field14 = $01
            local0\Field21 = $00
            local0\Field24 = $00
            freeentity(local0\Field3[$01])
            local0\Field3[$01] = $00
            local0 = createdoor(arg0\Field0, (arg0\Field3 - (896.0 * roomscale)), arg0\Field4, (arg0\Field5 - (640.0 * roomscale)), 90.0, arg0, $00, $02, $00, "", $00)
            local0\Field4 = $01
            local0\Field14 = $01
            local0\Field21 = $00
            local0\Field24 = $00
            freeentity(local0\Field3[$01])
            local0\Field3[$01] = $00
            arg0\Field19[$0A] = createpivot($00)
            positionentity(arg0\Field19[$0A], (arg0\Field3 - (832.0 * roomscale)), (arg0\Field4 - (3484.0 * roomscale)), (arg0\Field5 + (1572.0 * roomscale)), $00)
            arg0\Field19[$0B] = createpivot($00)
            positionentity(arg0\Field19[$0B], (arg0\Field3 + (2642.0 * roomscale)), (arg0\Field4 - (3516.0 * roomscale)), (arg0\Field5 + (1822.0 * roomscale)), $00)
            arg0\Field19[$0C] = createpivot($00)
            positionentity(arg0\Field19[$0C], (arg0\Field3 - (2666.0 * roomscale)), (arg0\Field4 - (3516.0 * roomscale)), (arg0\Field5 - (1792.0 * roomscale)), $00)
            arg0\Field19[$0D] = createpivot($00)
            positionentity(arg0\Field19[$0D], (arg0\Field3 - (554.0 * roomscale)), (arg0\Field4 - (3400.0 * roomscale)), (arg0\Field5 + (1493.0 * roomscale)), $00)
            For local7 = $0A To $0D Step $01
                entityparent(arg0\Field19[local7], arg0\Field2, $01)
            Next
        Case "room2_2"
            For local4 = Each rooms
                If (local4 <> arg0) Then
                    If (local4\Field7\Field10 = "room2_2") Then
                        arg0\Field19[$00] = copyentity(local4\Field19[$00], $00)
                        Exit
                    EndIf
                EndIf
            Next
            If (arg0\Field19[$00] = $00) Then
                arg0\Field19[$00] = loadrmesh(scpmodding_processfilepath("GFX\map\fan_opt.rmesh"), Null)
            EndIf
            scaleentity(arg0\Field19[$00], roomscale, roomscale, roomscale, $00)
            positionentity(arg0\Field19[$00], (arg0\Field3 - (248.0 * roomscale)), (arg0\Field4 + (528.0 * roomscale)), arg0\Field5, $00)
            entityparent(arg0\Field19[$00], arg0\Field2, $01)
        Case "room012"
            local0 = createdoor(arg0\Field0, (arg0\Field3 + (264.0 * roomscale)), arg0\Field4, (arg0\Field5 + (672.0 * roomscale)), 270.0, arg0, $00, $00, $05, "", $00)
            positionentity(local0\Field3[$00], (entityx(local0\Field3[$00], $01) - 0.03), entityy(local0\Field3[$00], $01), (entityz(local0\Field3[$00], $01) + 0.065), $01)
            positionentity(local0\Field3[$01], (entityx(local0\Field3[$01], $01) + 0.03), entityy(local0\Field3[$01], $01), (entityz(local0\Field3[$01], $01) - 0.065), $01)
            arg0\Field21[$00] = createdoor(arg0\Field0, (arg0\Field3 - (512.0 * roomscale)), (arg0\Field4 - (768.0 * roomscale)), (arg0\Field5 - (336.0 * roomscale)), 0.0, arg0, $00, $00, $00, "", $00)
            arg0\Field21[$00]\Field21 = $00
            arg0\Field21[$00]\Field5 = $00
            arg0\Field21[$00]\Field4 = $01
            positionentity(arg0\Field21[$00]\Field3[$00], (arg0\Field3 + (176.0 * roomscale)), (arg0\Field4 - (512.0 * roomscale)), (arg0\Field5 - (352.0 * roomscale)), $01)
            freeentity(arg0\Field21[$00]\Field3[$01])
            arg0\Field21[$00]\Field3[$01] = $00
            arg0\Field19[$00] = copyentity(local11\Field5[$00], $00)
            arg0\Field19[$01] = copyentity(local11\Field5[$01], $00)
            arg0\Field20[$00] = arg0\Field19[$01]
            For local7 = $00 To $01 Step $01
                scaleentity(arg0\Field19[local7], 0.04, 0.04, 0.04, $00)
                positionentity(arg0\Field19[local7], (arg0\Field3 + (240.0 * roomscale)), (arg0\Field4 - (512.0 * roomscale)), (arg0\Field5 - (364.0 * roomscale)), $01)
                entityparent(arg0\Field19[local7], arg0\Field2, $01)
            Next
            rotateentity(arg0\Field19[$01], 10.0, -180.0, 0.0, $00)
            entitypickmode(arg0\Field19[$01], $01, $00)
            entityradius(arg0\Field19[$01], 0.1, 0.0)
            arg0\Field19[$02] = loadrmesh(scpmodding_processfilepath("GFX\map\room012_2_opt.rmesh"), Null)
            scaleentity(arg0\Field19[$02], roomscale, roomscale, roomscale, $00)
            positionentity(arg0\Field19[$02], (arg0\Field3 - (360.0 * roomscale)), (arg0\Field4 - (130.0 * roomscale)), (arg0\Field5 + (456.0 * roomscale)), $00)
            entityparent(arg0\Field19[$02], arg0\Field2, $01)
            arg0\Field19[$03] = createsprite($00)
            positionentity(arg0\Field19[$03], (arg0\Field3 - (43.5 * roomscale)), (arg0\Field4 - (574.0 * roomscale)), (arg0\Field5 - (362.0 * roomscale)), $00)
            scalesprite(arg0\Field19[$03], 0.015, 0.015)
            entitytexture(arg0\Field19[$03], at\Field3[$01], $00, $00)
            entityblend(arg0\Field19[$03], $03)
            hideentity(arg0\Field19[$03])
            entityparent(arg0\Field19[$03], arg0\Field2, $01)
            If (arg0\Field19[$04] = $00) Then
                arg0\Field19[$04] = loadmesh_strict(scpmodding_processfilepath("GFX\map\room012_3.b3d"), $00)
            EndIf
            local23 = loadtexture_strict(scpmodding_processfilepath("GFX\map\scp-012_0.png"), $01)
            entitytexture(arg0\Field19[$04], local23, $00, $01)
            scaleentity(arg0\Field19[$04], roomscale, roomscale, roomscale, $00)
            positionentity(arg0\Field19[$04], (arg0\Field3 - (360.0 * roomscale)), (arg0\Field4 - (130.0 * roomscale)), (arg0\Field5 + (456.0 * roomscale)), $00)
            entityparent(arg0\Field19[$04], arg0\Field19[$02], $01)
            arg0\Field19[$05] = createpivot($00)
            positionentity(arg0\Field19[$05], arg0\Field3, arg0\Field4, arg0\Field5, $00)
            entityparent(arg0\Field19[$05], arg0\Field2, $01)
            local6 = createitem("Document SCP-012", "paper", (arg0\Field3 - (56.0 * roomscale)), (arg0\Field4 - (576.0 * roomscale)), (arg0\Field5 - (408.0 * roomscale)), $00, $00, $00, 1.0, $00)
            entityparent(local6\Field1, arg0\Field2, $01)
            local6 = createitem("Severed Hand", "hand", (arg0\Field3 - (784.0 * roomscale)), ((arg0\Field4 - (576.0 * roomscale)) + 0.3), (arg0\Field5 + (640.0 * roomscale)), $00, $00, $00, 1.0, $00)
            entityparent(local6\Field1, arg0\Field2, $01)
            local3 = createdecal($03, (arg0\Field3 - (784.0 * roomscale)), ((arg0\Field4 - (768.0 * roomscale)) + 0.01), (arg0\Field5 + (640.0 * roomscale)), 90.0, rnd(360.0, 0.0), 0.0)
            local3\Field2 = 0.5
            scalesprite(local3\Field0, local3\Field2, local3\Field2)
            entityparent(local3\Field0, arg0\Field2, $01)
        Case "tunnel2"
            arg0\Field19[$00] = createpivot($00)
            positionentity(arg0\Field19[$00], arg0\Field3, (544.0 * roomscale), (arg0\Field5 + (512.0 * roomscale)), $00)
            arg0\Field19[$01] = createpivot($00)
            positionentity(arg0\Field19[$01], arg0\Field3, (544.0 * roomscale), (arg0\Field5 - (512.0 * roomscale)), $00)
            For local7 = $00 To $01 Step $01
                entityparent(arg0\Field19[local7], arg0\Field2, $01)
            Next
        Case "room2pipes"
            arg0\Field19[$00] = createpivot($00)
            positionentity(arg0\Field19[$00], (arg0\Field3 + (368.0 * roomscale)), arg0\Field4, arg0\Field5, $00)
            arg0\Field19[$01] = createpivot($00)
            positionentity(arg0\Field19[$01], (arg0\Field3 - (368.0 * roomscale)), arg0\Field4, arg0\Field5, $00)
            arg0\Field19[$02] = createpivot($00)
            positionentity(arg0\Field19[$02], ((arg0\Field3 + (224.0 * roomscale)) - 0.005), (arg0\Field4 + (192.0 * roomscale)), arg0\Field5, $00)
            arg0\Field19[$03] = createpivot($00)
            positionentity(arg0\Field19[$03], ((arg0\Field3 - (224.0 * roomscale)) + 0.005), (arg0\Field4 + (192.0 * roomscale)), arg0\Field5, $00)
            For local7 = $00 To $03 Step $01
                entityparent(arg0\Field19[local7], arg0\Field2, $01)
            Next
        Case "room3pit"
            local15 = createemitter((arg0\Field3 + (512.0 * roomscale)), (arg0\Field4 - (76.0 * roomscale)), (arg0\Field5 - (688.0 * roomscale)), $00)
            turnentity(local15\Field0, -90.0, 0.0, 0.0, $00)
            entityparent(local15\Field0, arg0\Field2, $01)
            local15\Field10 = 55.0
            local15\Field9 = 0.0005
            local15\Field12 = -0.015
            local15\Field11 = 0.007
            local15 = createemitter((arg0\Field3 - (512.0 * roomscale)), (arg0\Field4 - (76.0 * roomscale)), (arg0\Field5 - (688.0 * roomscale)), $00)
            turnentity(local15\Field0, -90.0, 0.0, 0.0, $00)
            entityparent(local15\Field0, arg0\Field2, $01)
            local15\Field10 = 55.0
            local15\Field9 = 0.0005
            local15\Field12 = -0.015
            local15\Field11 = 0.007
            arg0\Field19[$00] = createpivot(arg0\Field2)
            positionentity(arg0\Field19[$00], (arg0\Field3 + (704.0 * roomscale)), (arg0\Field4 + (112.0 * roomscale)), (arg0\Field5 - (416.0 * roomscale)), $01)
        Case "room2servers"
            local0 = createdoor($00, arg0\Field3, arg0\Field4, arg0\Field5, 0.0, arg0, $00, $02, $00, "", $00)
            local0\Field4 = $01
            arg0\Field21[$00] = createdoor(arg0\Field0, (arg0\Field3 - (208.0 * roomscale)), arg0\Field4, (arg0\Field5 - (736.0 * roomscale)), 90.0, arg0, $01, $00, $00, "", $01)
            arg0\Field21[$00]\Field21 = $00
            positionentity(arg0\Field21[$00]\Field3[$00], (entityx(arg0\Field21[$00]\Field3[$00], $01) - 0.061), entityy(arg0\Field21[$00]\Field3[$00], $01), entityz(arg0\Field21[$00]\Field3[$00], $01), $01)
            positionentity(arg0\Field21[$00]\Field3[$01], (entityx(arg0\Field21[$00]\Field3[$01], $01) + 0.061), entityy(arg0\Field21[$00]\Field3[$01], $01), entityz(arg0\Field21[$00]\Field3[$01], $01), $01)
            arg0\Field21[$01] = createdoor(arg0\Field0, (arg0\Field3 - (208.0 * roomscale)), arg0\Field4, (arg0\Field5 + (736.0 * roomscale)), 90.0, arg0, $01, $00, $00, "", $01)
            arg0\Field21[$01]\Field21 = $00
            positionentity(arg0\Field21[$01]\Field3[$00], (entityx(arg0\Field21[$01]\Field3[$00], $01) - 0.061), entityy(arg0\Field21[$01]\Field3[$00], $01), entityz(arg0\Field21[$01]\Field3[$00], $01), $01)
            positionentity(arg0\Field21[$01]\Field3[$01], (entityx(arg0\Field21[$01]\Field3[$01], $01) + 0.061), entityy(arg0\Field21[$01]\Field3[$01], $01), entityz(arg0\Field21[$01]\Field3[$01], $01), $01)
            arg0\Field21[$02] = createdoor(arg0\Field0, (arg0\Field3 - (672.0 * roomscale)), arg0\Field4, (arg0\Field5 - (1024.0 * roomscale)), 0.0, arg0, $00, $00, $00, "ABCD", $00)
            arg0\Field21[$02]\Field21 = $00
            arg0\Field21[$02]\Field14 = $01
            freeentity(arg0\Field21[$02]\Field3[$00])
            arg0\Field21[$02]\Field3[$00] = $00
            freeentity(arg0\Field21[$02]\Field3[$01])
            arg0\Field21[$02]\Field3[$01] = $00
            For local17 = $00 To $02 Step $01
                arg0\Field19[(local17 Shl $01)] = copyentity(local11\Field5[$00], $00)
                arg0\Field19[((local17 Shl $01) + $01)] = copyentity(local11\Field5[$01], $00)
                arg0\Field20[local17] = arg0\Field19[((local17 Shl $01) + $01)]
                For local7 = $00 To $01 Step $01
                    scaleentity(arg0\Field19[((local17 Shl $01) + local7)], 0.03, 0.03, 0.03, $00)
                    Select local17
                        Case $00
                            positionentity(arg0\Field19[((local17 Shl $01) + local7)], (arg0\Field3 - (1260.0 * roomscale)), (arg0\Field4 + (234.0 * roomscale)), (arg0\Field5 + (750.0 * roomscale)), $01)
                        Case $01
                            positionentity(arg0\Field19[((local17 Shl $01) + local7)], (arg0\Field3 - (920.0 * roomscale)), (arg0\Field4 + (164.0 * roomscale)), (arg0\Field5 + (898.0 * roomscale)), $01)
                        Case $02
                            positionentity(arg0\Field19[((local17 Shl $01) + local7)], (arg0\Field3 - (837.0 * roomscale)), (arg0\Field4 + (152.0 * roomscale)), (arg0\Field5 + (886.0 * roomscale)), $01)
                    End Select
                    entityparent(arg0\Field19[((local17 Shl $01) + local7)], arg0\Field2, $01)
                Next
                rotateentity(arg0\Field19[((local17 Shl $01) + $01)], 81.0, -180.0, 0.0, $00)
                entitypickmode(arg0\Field19[((local17 Shl $01) + $01)], $01, $00)
                entityradius(arg0\Field19[((local17 Shl $01) + $01)], 0.1, 0.0)
            Next
            rotateentity(arg0\Field19[$03], -81.0, -180.0, 0.0, $00)
            rotateentity(arg0\Field19[$05], -81.0, -180.0, 0.0, $00)
            arg0\Field19[$06] = createpivot($00)
            positionentity(arg0\Field19[$06], (arg0\Field3 - (320.0 * roomscale)), (arg0\Field4 + 0.5), arg0\Field5, $00)
            arg0\Field19[$07] = createpivot($00)
            positionentity(arg0\Field19[$07], (arg0\Field3 - (1328.0 * roomscale)), (arg0\Field4 + 0.5), (arg0\Field5 + (528.0 * roomscale)), $00)
            arg0\Field19[$08] = createpivot($00)
            positionentity(arg0\Field19[$08], (arg0\Field3 - (1376.0 * roomscale)), (arg0\Field4 + 0.5), (arg0\Field5 + (32.0 * roomscale)), $00)
            arg0\Field19[$09] = createpivot($00)
            positionentity(arg0\Field19[$09], (arg0\Field3 - (848.0 * roomscale)), (arg0\Field4 + 0.5), (arg0\Field5 + (576.0 * roomscale)), $00)
            For local7 = $06 To $09 Step $01
                entityparent(arg0\Field19[local7], arg0\Field2, $01)
            Next
        Case "room3servers"
            local6 = createitem("9V Battery", "bat", (arg0\Field3 - (132.0 * roomscale)), (arg0\Field4 - (368.0 * roomscale)), (arg0\Field5 - (648.0 * roomscale)), $00, $00, $00, 1.0, $00)
            entityparent(local6\Field1, arg0\Field2, $01)
            If (rand($02, $01) = $01) Then
                local6 = createitem("9V Battery", "bat", (arg0\Field3 - (76.0 * roomscale)), (arg0\Field4 - (368.0 * roomscale)), (arg0\Field5 - (648.0 * roomscale)), $00, $00, $00, 1.0, $00)
                entityparent(local6\Field1, arg0\Field2, $01)
            EndIf
            If (rand($02, $01) = $01) Then
                local6 = createitem("9V Battery", "bat", (arg0\Field3 - (196.0 * roomscale)), (arg0\Field4 - (368.0 * roomscale)), (arg0\Field5 - (648.0 * roomscale)), $00, $00, $00, 1.0, $00)
                entityparent(local6\Field1, arg0\Field2, $01)
            EndIf
            local6 = createitem("S-NAV 300 Navigator", "nav", (arg0\Field3 + (124.0 * roomscale)), (arg0\Field4 - (368.0 * roomscale)), (arg0\Field5 - (648.0 * roomscale)), $00, $00, $00, 1.0, $00)
            local6\Field13 = 20.0
            entityparent(local6\Field1, arg0\Field2, $01)
            arg0\Field19[$00] = createpivot($00)
            positionentity(arg0\Field19[$00], (arg0\Field3 + (736.0 * roomscale)), (arg0\Field4 - (512.0 * roomscale)), (arg0\Field5 - (400.0 * roomscale)), $00)
            arg0\Field19[$01] = createpivot($00)
            positionentity(arg0\Field19[$01], (arg0\Field3 - (552.0 * roomscale)), (arg0\Field4 - (512.0 * roomscale)), (arg0\Field5 - (528.0 * roomscale)), $00)
            arg0\Field19[$02] = createpivot($00)
            positionentity(arg0\Field19[$02], (arg0\Field3 + (736.0 * roomscale)), (arg0\Field4 - (512.0 * roomscale)), (arg0\Field5 + (272.0 * roomscale)), $00)
            arg0\Field19[$03] = copyentity(local11\Field0[$1E], $00)
            scaleentity(arg0\Field19[$03], 0.07, 0.07, 0.07, $00)
            local23 = loadtexture_strict("GFX\npcs\duck(2).png", $01)
            entitytexture(arg0\Field19[$03], local23, $00, $00)
            positionentity(arg0\Field19[$03], (arg0\Field3 + (928.0 * roomscale)), (arg0\Field4 - (640.0 * roomscale)), (arg0\Field5 + (704.0 * roomscale)), $00)
            For local7 = $00 To $03 Step $01
                entityparent(arg0\Field19[local7], arg0\Field2, $01)
            Next
        Case "room3servers2"
            arg0\Field19[$00] = createpivot($00)
            positionentity(arg0\Field19[$00], (arg0\Field3 - (504.0 * roomscale)), (arg0\Field4 - (512.0 * roomscale)), (arg0\Field5 + (271.0 * roomscale)), $00)
            arg0\Field19[$01] = createpivot($00)
            positionentity(arg0\Field19[$01], (arg0\Field3 + (628.0 * roomscale)), (arg0\Field4 - (512.0 * roomscale)), (arg0\Field5 + (271.0 * roomscale)), $00)
            arg0\Field19[$02] = createpivot($00)
            positionentity(arg0\Field19[$02], (arg0\Field3 - (532.0 * roomscale)), (arg0\Field4 - (512.0 * roomscale)), (arg0\Field5 - (877.0 * roomscale)), $00)
            For local7 = $00 To $02 Step $01
                entityparent(arg0\Field19[local7], arg0\Field2, $01)
            Next
            local6 = createitem("Document SCP-970", "paper", (arg0\Field3 + (960.0 * roomscale)), (arg0\Field4 - (448.0 * roomscale)), (arg0\Field5 + (251.0 * roomscale)), $00, $00, $00, 1.0, $00)
            entityparent(local6\Field1, arg0\Field2, $01)
            rotateentity(local6\Field1, 0.0, (Float arg0\Field6), 0.0, $00)
            local6 = createitem("Gas Mask", "gasmask", (arg0\Field3 + (954.0 * roomscale)), (arg0\Field4 - (504.0 * roomscale)), (arg0\Field5 + (235.0 * roomscale)), $00, $00, $00, 1.0, $00)
            entityparent(local6\Field1, arg0\Field2, $01)
        Case "room2testroom"
            For local8 = $00 To $01 Step $01
                For local10 = $FFFFFFFF To $01 Step $01
                    arg0\Field19[((local8 * $03) + (local10 + $01))] = createpivot($00)
                    positionentity(arg0\Field19[((local8 * $03) + (local10 + $01))], (arg0\Field3 + (((280.0 * (Float local8)) + -236.0) * roomscale)), (-700.0 * roomscale), (arg0\Field5 + ((384.0 * (Float local10)) * roomscale)), $00)
                    entityparent(arg0\Field19[((local8 * $03) + (local10 + $01))], arg0\Field2, $01)
                Next
            Next
            arg0\Field19[$06] = createpivot($00)
            positionentity(arg0\Field19[$06], (arg0\Field3 + (754.0 * roomscale)), (arg0\Field4 - (1248.0 * roomscale)), arg0\Field5, $00)
            entityparent(arg0\Field19[$06], arg0\Field2, $01)
            local2 = createsecuritycam((arg0\Field3 + (744.0 * roomscale)), (arg0\Field4 - (856.0 * roomscale)), (arg0\Field5 + (236.0 * roomscale)), arg0, $00)
            local2\Field20 = $01
            arg0\Field21[$00] = createdoor($00, (arg0\Field3 + (720.0 * roomscale)), arg0\Field4, arg0\Field5, 0.0, arg0, $00, $02, $FFFFFFFF, "", $00)
            arg0\Field21[$00]\Field21 = $00
            local0 = createdoor($00, (arg0\Field3 - (624.0 * roomscale)), (arg0\Field4 - (1280.0 * roomscale)), arg0\Field5, 90.0, arg0, $01, $00, $00, "", $00)
            positionentity(local0\Field3[$00], (entityx(local0\Field3[$00], $01) - 0.03), entityy(local0\Field3[$00], $01), entityz(local0\Field3[$00], $01), $01)
            positionentity(local0\Field3[$01], (entityx(local0\Field3[$01], $01) + 0.03), entityy(local0\Field3[$01], $01), entityz(local0\Field3[$01], $01), $01)
            local6 = createitem("Document SCP-682", "paper", (arg0\Field3 + (656.0 * roomscale)), (arg0\Field4 - (1200.0 * roomscale)), (arg0\Field5 - (16.0 * roomscale)), $00, $00, $00, 1.0, $00)
            entityparent(local6\Field1, arg0\Field2, $01)
        Case "room2closets"
            local6 = createitem("Document SCP-1048", "paper", (arg0\Field3 + (736.0 * roomscale)), (arg0\Field4 + (176.0 * roomscale)), (arg0\Field5 + (736.0 * roomscale)), $00, $00, $00, 1.0, $00)
            entityparent(local6\Field1, arg0\Field2, $01)
            local6 = createitem("Gas Mask", "gasmask", (arg0\Field3 + (736.0 * roomscale)), (arg0\Field4 + (176.0 * roomscale)), (arg0\Field5 + (544.0 * roomscale)), $00, $00, $00, 1.0, $00)
            entityparent(local6\Field1, arg0\Field2, $01)
            local6 = createitem("9V Battery", "bat", (arg0\Field3 + (736.0 * roomscale)), (arg0\Field4 + (176.0 * roomscale)), (arg0\Field5 - (448.0 * roomscale)), $00, $00, $00, 1.0, $00)
            entityparent(local6\Field1, arg0\Field2, $01)
            If (rand($02, $01) = $01) Then
                local6 = createitem("9V Battery", "bat", (arg0\Field3 + (730.0 * roomscale)), (arg0\Field4 + (176.0 * roomscale)), (arg0\Field5 - (496.0 * roomscale)), $00, $00, $00, 1.0, $00)
                entityparent(local6\Field1, arg0\Field2, $01)
            EndIf
            If (rand($02, $01) = $01) Then
                local6 = createitem("9V Battery", "bat", (arg0\Field3 + (740.0 * roomscale)), (arg0\Field4 + (176.0 * roomscale)), (arg0\Field5 - (560.0 * roomscale)), $00, $00, $00, 1.0, $00)
                entityparent(local6\Field1, arg0\Field2, $01)
            EndIf
            local6 = createitem("Level 0 Key Card", "key0", (arg0\Field3 + (736.0 * roomscale)), (arg0\Field4 + (240.0 * roomscale)), (arg0\Field5 + (752.0 * roomscale)), $00, $00, $00, 1.0, $00)
            entityparent(local6\Field1, arg0\Field2, $01)
            local25 = createitem("Clipboard", "clipboard", (arg0\Field3 + (736.0 * roomscale)), (arg0\Field4 + (224.0 * roomscale)), (arg0\Field5 - (480.0 * roomscale)), $00, $00, $00, 1.0, $00)
            entityparent(local6\Field1, arg0\Field2, $01)
            local6 = createitem("Incident Report SCP-1048-A", "paper", (arg0\Field3 + (736.0 * roomscale)), (arg0\Field4 + (224.0 * roomscale)), (arg0\Field5 - (480.0 * roomscale)), $00, $00, $00, 1.0, $00)
            hideentity(local6\Field1)
            arg0\Field19[$00] = createpivot($00)
            positionentity(arg0\Field19[$00], (arg0\Field3 - (1180.0 * roomscale)), (arg0\Field4 - (256.0 * roomscale)), (arg0\Field5 + (896.0 * roomscale)), $00)
            entityparent(arg0\Field19[$00], arg0\Field2, $01)
            arg0\Field19[$01] = createpivot($00)
            positionentity(arg0\Field19[$01], (arg0\Field3 - (1292.0 * roomscale)), (arg0\Field4 - (256.0 * roomscale)), (arg0\Field5 - (160.0 * roomscale)), $00)
            entityparent(arg0\Field19[$01], arg0\Field2, $01)
            arg0\Field19[$02] = createpivot($00)
            positionentity(arg0\Field19[$02], (arg0\Field3 - (1065.0 * roomscale)), (arg0\Field4 - (380.0 * roomscale)), (arg0\Field5 + (30.0 * roomscale)), $00)
            entityparent(arg0\Field19[$02], arg0\Field2, $01)
            local0 = createdoor(arg0\Field0, (arg0\Field3 - (240.0 * roomscale)), (arg0\Field4 - (0.5 * roomscale)), arg0\Field5, 90.0, arg0, $00, $00, $00, "", $00)
            positionentity(local0\Field3[$00], (arg0\Field3 - (230.0 * roomscale)), entityy(local0\Field3[$00], $01), entityz(local0\Field3[$00], $01), $01)
            positionentity(local0\Field3[$01], (arg0\Field3 - (250.0 * roomscale)), entityy(local0\Field3[$01], $01), entityz(local0\Field3[$01], $01), $01)
            local0\Field5 = $00
            local0\Field21 = $00
            local2 = createsecuritycam(arg0\Field3, (arg0\Field4 + (704.0 * roomscale)), (arg0\Field5 + (863.0 * roomscale)), arg0, $00)
            local2\Field11 = 180.0
            local2\Field12 = 45.0
            turnentity(local2\Field3, 20.0, 0.0, 0.0, $00)
        Case "room2offices"
            local6 = createitem("Document SCP-106", "paper", (arg0\Field3 + (404.0 * roomscale)), (arg0\Field4 + (145.0 * roomscale)), (arg0\Field5 + (559.0 * roomscale)), $00, $00, $00, 1.0, $00)
            entityparent(local6\Field1, arg0\Field2, $01)
            local6 = createitem("Level 2 Key Card", "key2", (arg0\Field3 - (156.0 * roomscale)), (arg0\Field4 + (151.0 * roomscale)), (arg0\Field5 + (72.0 * roomscale)), $00, $00, $00, 1.0, $00)
            entityparent(local6\Field1, arg0\Field2, $01)
            local6 = createitem("S-NAV 300 Navigator", "nav", (arg0\Field3 + (305.0 * roomscale)), (arg0\Field4 + (153.0 * roomscale)), (arg0\Field5 + (944.0 * roomscale)), $00, $00, $00, 1.0, $00)
            local6\Field13 = 20.0
            entityparent(local6\Field1, arg0\Field2, $01)
            local6 = createitem("Notification", "paper", (arg0\Field3 - (137.0 * roomscale)), (arg0\Field4 + (153.0 * roomscale)), (arg0\Field5 + (464.0 * roomscale)), $00, $00, $00, 1.0, $00)
            entityparent(local6\Field1, arg0\Field2, $01)
            local26 = createwaypoint((arg0\Field3 - (32.0 * roomscale)), (arg0\Field4 + (66.0 * roomscale)), (arg0\Field5 + (288.0 * roomscale)), Null, arg0)
            local27 = createwaypoint(arg0\Field3, (arg0\Field4 + (66.0 * roomscale)), (arg0\Field5 - (448.0 * roomscale)), Null, arg0)
            local26\Field4[$00] = local27
            local26\Field5[$00] = entitydistance(local26\Field0, local27\Field0)
            local27\Field4[$00] = local26
            local27\Field5[$00] = local26\Field5[$00]
        Case "room2offices2"
            local6 = createitem("Level 1 Key Card", "key1", (arg0\Field3 - (368.0 * roomscale)), (arg0\Field4 - (48.0 * roomscale)), (arg0\Field5 + (80.0 * roomscale)), $00, $00, $00, 1.0, $00)
            entityparent(local6\Field1, arg0\Field2, $01)
            local6 = createitem("Document SCP-895", "paper", (arg0\Field3 - (800.0 * roomscale)), (arg0\Field4 - (48.0 * roomscale)), (arg0\Field5 + (368.0 * roomscale)), $00, $00, $00, 1.0, $00)
            entityparent(local6\Field1, arg0\Field2, $01)
            If (rand($02, $01) = $01) Then
                local6 = createitem("Document SCP-860", "paper", (arg0\Field3 - (800.0 * roomscale)), (arg0\Field4 - (48.0 * roomscale)), (arg0\Field5 - (464.0 * roomscale)), $00, $00, $00, 1.0, $00)
            Else
                local6 = createitem("SCP-093 Recovered Materials", "paper", (arg0\Field3 - (800.0 * roomscale)), (arg0\Field4 - (48.0 * roomscale)), (arg0\Field5 - (464.0 * roomscale)), $00, $00, $00, 1.0, $00)
            EndIf
            entityparent(local6\Field1, arg0\Field2, $01)
            local6 = createitem("S-NAV 300 Navigator", "nav", (arg0\Field3 - (336.0 * roomscale)), (arg0\Field4 - (48.0 * roomscale)), (arg0\Field5 - (480.0 * roomscale)), $00, $00, $00, 1.0, $00)
            local6\Field13 = 28.0
            entityparent(local6\Field1, arg0\Field2, $01)
            arg0\Field19[$00] = copyentity(local11\Field0[$1E], $00)
            scaleentity(arg0\Field19[$00], 0.07, 0.07, 0.07, $00)
            arg0\Field19[$01] = createpivot($00)
            positionentity(arg0\Field19[$01], (arg0\Field3 - (808.0 * roomscale)), (arg0\Field4 - (72.0 * roomscale)), (arg0\Field5 - (40.0 * roomscale)), $00)
            arg0\Field19[$02] = createpivot($00)
            positionentity(arg0\Field19[$02], (arg0\Field3 - (488.0 * roomscale)), (arg0\Field4 + (160.0 * roomscale)), (arg0\Field5 + (700.0 * roomscale)), $00)
            arg0\Field19[$03] = createpivot($00)
            positionentity(arg0\Field19[$03], (arg0\Field3 - (488.0 * roomscale)), (arg0\Field4 + (160.0 * roomscale)), (arg0\Field5 - (668.0 * roomscale)), $00)
            arg0\Field19[$04] = createpivot($00)
            positionentity(arg0\Field19[$04], (arg0\Field3 - (572.0 * roomscale)), (arg0\Field4 + (350.0 * roomscale)), (arg0\Field5 - (4.0 * roomscale)), $00)
            local18 = rand($01, $04)
            positionentity(arg0\Field19[$00], entityx(arg0\Field19[local18], $01), entityy(arg0\Field19[local18], $01), entityz(arg0\Field19[local18], $01), $00)
            For local7 = $00 To $04 Step $01
                entityparent(arg0\Field19[local7], arg0\Field2, $01)
            Next
        Case "room2offices3"
            If (rand($02, $01) = $01) Then
                local6 = createitem("Mobile Task Forces", "paper", (arg0\Field3 + (744.0 * roomscale)), (arg0\Field4 + (240.0 * roomscale)), (arg0\Field5 + (944.0 * roomscale)), $00, $00, $00, 1.0, $00)
                entityparent(local6\Field1, arg0\Field2, $01)
            Else
                local6 = createitem("Security Clearance Levels", "paper", (arg0\Field3 + (680.0 * roomscale)), (arg0\Field4 + (240.0 * roomscale)), (arg0\Field5 + (944.0 * roomscale)), $00, $00, $00, 1.0, $00)
                entityparent(local6\Field1, arg0\Field2, $01)
            EndIf
            local6 = createitem("Object Classes", "paper", (arg0\Field3 + (160.0 * roomscale)), (arg0\Field4 + (240.0 * roomscale)), (arg0\Field5 + (568.0 * roomscale)), $00, $00, $00, 1.0, $00)
            entityparent(local6\Field1, arg0\Field2, $01)
            local6 = createitem("Document", "paper", (arg0\Field3 - (1440.0 * roomscale)), (arg0\Field4 + (624.0 * roomscale)), (arg0\Field5 + (152.0 * roomscale)), $00, $00, $00, 1.0, $00)
            entityparent(local6\Field1, arg0\Field2, $01)
            local6 = createitem("Radio Transceiver", "radio", (arg0\Field3 - (1184.0 * roomscale)), (arg0\Field4 + (480.0 * roomscale)), (arg0\Field5 - (800.0 * roomscale)), $00, $00, $00, 1.0, $00)
            entityparent(local6\Field1, arg0\Field2, $01)
            For local7 = $00 To rand($00, $01) Step $01
                local6 = createitem("ReVision Eyedrops", "eyedrops", (arg0\Field3 - (1529.0 * roomscale)), (arg0\Field4 + (563.0 * roomscale)), ((arg0\Field5 - (572.0 * roomscale)) + ((Float local7) * 0.05)), $00, $00, $00, 1.0, $00)
                entityparent(local6\Field1, arg0\Field2, $01)
            Next
            local6 = createitem("9V Battery", "bat", (arg0\Field3 - (1545.0 * roomscale)), (arg0\Field4 + (603.0 * roomscale)), (arg0\Field5 - (372.0 * roomscale)), $00, $00, $00, 1.0, $00)
            entityparent(local6\Field1, arg0\Field2, $01)
            If (rand($02, $01) = $01) Then
                local6 = createitem("9V Battery", "bat", (arg0\Field3 - (1540.0 * roomscale)), (arg0\Field4 + (603.0 * roomscale)), (arg0\Field5 - (340.0 * roomscale)), $00, $00, $00, 1.0, $00)
                entityparent(local6\Field1, arg0\Field2, $01)
            EndIf
            If (rand($02, $01) = $01) Then
                local6 = createitem("9V Battery", "bat", (arg0\Field3 - (1529.0 * roomscale)), (arg0\Field4 + (603.0 * roomscale)), (arg0\Field5 - (308.0 * roomscale)), $00, $00, $00, 1.0, $00)
                entityparent(local6\Field1, arg0\Field2, $01)
            EndIf
            arg0\Field21[$00] = createdoor(arg0\Field0, (arg0\Field3 - (1056.0 * roomscale)), (arg0\Field4 + (384.0 * roomscale)), (arg0\Field5 + (290.0 * roomscale)), 90.0, arg0, $00, $00, $05, "", $00)
            arg0\Field21[$00]\Field21 = $00
        Case "room173"
            arg0\Field21[$01] = createdoor(arg0\Field0, (arg0\Field3 + (4000.0 * roomscale)), (arg0\Field4 + (384.0 * roomscale)), (arg0\Field5 + (1696.0 * roomscale)), 90.0, arg0, $01, $01, $00, "", $00)
            arg0\Field21[$01]\Field4 = $00
            arg0\Field21[$01]\Field21 = $00
            arg0\Field21[$01]\Field24 = $00
            arg0\Field21[$01]\Field9 = $01
            arg0\Field21[$01]\Field5 = $01
            freeentity(arg0\Field21[$01]\Field3[$00])
            arg0\Field21[$01]\Field3[$00] = $00
            freeentity(arg0\Field21[$01]\Field3[$01])
            arg0\Field21[$01]\Field3[$01] = $00
            arg0\Field21[$02] = createdoor(arg0\Field0, (arg0\Field3 + (2704.0 * roomscale)), (arg0\Field4 + (384.0 * roomscale)), (arg0\Field5 + (624.0 * roomscale)), 90.0, arg0, $00, $00, $00, "", $00)
            arg0\Field21[$02]\Field21 = $00
            arg0\Field21[$02]\Field5 = $00
            arg0\Field21[$02]\Field24 = $00
            freeentity(arg0\Field21[$02]\Field3[$00])
            arg0\Field21[$02]\Field3[$00] = $00
            freeentity(arg0\Field21[$02]\Field3[$01])
            arg0\Field21[$02]\Field3[$01] = $00
            local0 = createdoor(arg0\Field0, (arg0\Field3 + (1392.0 * roomscale)), (arg0\Field4 + (384.0 * roomscale)), (arg0\Field5 + (64.0 * roomscale)), 90.0, arg0, $01, $00, $00, "", $00)
            local0\Field21 = $00
            local0\Field24 = $00
            local0\Field4 = $01
            local0 = createdoor(arg0\Field0, (arg0\Field3 - (640.0 * roomscale)), (arg0\Field4 + (384.0 * roomscale)), (arg0\Field5 + (64.0 * roomscale)), 90.0, arg0, $00, $00, $00, "", $00)
            local0\Field4 = $01
            local0\Field21 = $00
            local0\Field24 = $00
            freeentity(local0\Field3[$01])
            local0\Field3[$01] = $00
            local0 = createdoor(arg0\Field0, (arg0\Field3 + (1280.0 * roomscale)), (arg0\Field4 + (383.9 * roomscale)), (arg0\Field5 + (312.0 * roomscale)), 180.0, arg0, $01, $00, $00, "", $00)
            local0\Field4 = $01
            local0\Field21 = $00
            local0\Field24 = $00
            positionentity(local0\Field3[$00], (arg0\Field3 + (1120.0 * roomscale)), entityy(local0\Field3[$00], $01), (arg0\Field5 + (322.0 * roomscale)), $01)
            positionentity(local0\Field3[$01], (arg0\Field3 + (1120.0 * roomscale)), entityy(local0\Field3[$01], $01), (arg0\Field5 + (302.0 * roomscale)), $01)
            freeentity(local0\Field1)
            local0\Field1 = $00
            local0 = createdoor(arg0\Field0, arg0\Field3, arg0\Field4, (arg0\Field5 + (1184.0 * roomscale)), 0.0, arg0, $00, $00, $00, "", $00)
            local0\Field4 = $01
            local0\Field24 = $00
            freeentity(local0\Field3[$01])
            local0\Field3[$01] = $00
            arg0\Field19[$00] = loadrmesh(scpmodding_processfilepath("GFX\map\IntroDesk_opt.rmesh"), Null)
            scaleentity(arg0\Field19[$00], roomscale, roomscale, roomscale, $00)
            positionentity(arg0\Field19[$00], (arg0\Field3 + (272.0 * roomscale)), arg0\Field4, (arg0\Field5 + (400.0 * roomscale)), $00)
            entityparent(arg0\Field19[$00], arg0\Field2, $01)
            local3 = createdecal($00, (arg0\Field3 + (272.0 * roomscale)), (arg0\Field4 + 0.005), (arg0\Field5 + (262.0 * roomscale)), 90.0, (Float rand($168, $01)), 0.0)
            entityparent(local3\Field0, arg0\Field2, $01)
            arg0\Field19[$01] = loadrmesh(scpmodding_processfilepath("GFX\map\IntroDrawer_opt.rmesh"), Null)
            scaleentity(arg0\Field19[$01], roomscale, roomscale, roomscale, $00)
            positionentity(arg0\Field19[$01], (arg0\Field3 + (448.0 * roomscale)), arg0\Field4, (arg0\Field5 + (192.0 * roomscale)), $00)
            entityparent(arg0\Field19[$01], arg0\Field2, $01)
            local3 = createdecal($00, (arg0\Field3 + (456.0 * roomscale)), (arg0\Field4 + 0.005), (arg0\Field5 + (135.0 * roomscale)), 90.0, (Float rand($168, $01)), 0.0)
            For local7 = $00 To $04 Step $01
                Select local7
                    Case $00
                        local28 = 5222.0
                        local29 = 1224.0
                        local30 = 0.54
                        local31 = $04
                    Case $01
                        local28 = 5190.0
                        local29 = 2270.0
                        local30 = 1.2
                        local31 = $04
                    Case $02
                        local28 = 4305.0
                        local29 = 1234.0
                        local30 = 0.44
                        local31 = $04
                    Case $03
                        local28 = 4320.0
                        local29 = 2000.0
                        local30 = 0.54
                        local31 = $04
                    Case $04
                        local28 = 4978.0
                        local29 = 1985.0
                        local30 = 0.54
                        local31 = $06
                End Select
                local3 = createdecal(local31, (arg0\Field3 + (local28 * roomscale)), (arg0\Field4 + (386.0 * roomscale)), (arg0\Field5 + (local29 * roomscale)), 90.0, 45.0, 0.0)
                local3\Field2 = local30
                local3\Field5 = rnd(0.8, 1.0)
                scalesprite(local3\Field0, local3\Field2, local3\Field2)
            Next
            local2 = createsecuritycam((arg0\Field3 - (336.0 * roomscale)), (arg0\Field4 + (352.0 * roomscale)), (arg0\Field5 + (48.0 * roomscale)), arg0, $01)
            local2\Field11 = 270.0
            local2\Field12 = 45.0
            local2\Field19 = arg0
            turnentity(local2\Field3, 20.0, 0.0, 0.0, $00)
            entityparent(local2\Field0, arg0\Field2, $01)
            positionentity(local2\Field4, (arg0\Field3 + (1456.0 * roomscale)), (arg0\Field4 + (608.0 * roomscale)), (arg0\Field5 + (352.0 * roomscale)), $00)
            turnentity(local2\Field4, 0.0, 90.0, 0.0, $00)
            entityparent(local2\Field4, arg0\Field2, $01)
            arg0\Field19[$02] = createpivot($00)
            positionentity(arg0\Field19[$02], (entityx(arg0\Field2, $00) + (40.0 * roomscale)), (arg0\Field4 + (460.0 * roomscale)), (entityz(arg0\Field2, $00) + (1072.0 * roomscale)), $00)
            entityparent(arg0\Field19[$02], arg0\Field2, $01)
            arg0\Field19[$03] = createpivot($00)
            positionentity(arg0\Field19[$03], (entityx(arg0\Field2, $00) + (310.0 * roomscale)), (arg0\Field4 + (100.0 * roomscale)), (entityz(arg0\Field2, $00) + (586.0 * roomscale)), $00)
            entityparent(arg0\Field19[$03], arg0\Field2, $01)
            arg0\Field19[$04] = createpivot($00)
            positionentity(arg0\Field19[$04], (entityx(arg0\Field2, $00) - (128.0 * roomscale)), (arg0\Field4 + (100.0 * roomscale)), (entityz(arg0\Field2, $00) + (320.0 * roomscale)), $00)
            entityparent(arg0\Field19[$04], arg0\Field2, $01)
            arg0\Field19[$05] = createpivot($00)
            positionentity(arg0\Field19[$05], (entityx(arg0\Field2, $00) + (660.0 * roomscale)), (arg0\Field4 + (100.0 * roomscale)), (entityz(arg0\Field2, $00) + (526.0 * roomscale)), $00)
            entityparent(arg0\Field19[$05], arg0\Field2, $01)
            arg0\Field19[$06] = createpivot($00)
            positionentity(arg0\Field19[$06], (entityx(arg0\Field2, $00) + (700.0 * roomscale)), (arg0\Field4 + (100.0 * roomscale)), (entityz(arg0\Field2, $00) + (320.0 * roomscale)), $00)
            entityparent(arg0\Field19[$06], arg0\Field2, $01)
            arg0\Field19[$07] = createpivot($00)
            positionentity(arg0\Field19[$07], (entityx(arg0\Field2, $00) + (1472.0 * roomscale)), (arg0\Field4 + (100.0 * roomscale)), (entityz(arg0\Field2, $00) + (912.0 * roomscale)), $00)
            entityparent(arg0\Field19[$07], arg0\Field2, $01)
            createdevilemitter((arg0\Field3 + (3384.0 * roomscale)), (arg0\Field4 + (510.0 * roomscale)), (arg0\Field5 + (2400.0 * roomscale)), arg0, $01, 4.0)
            local6 = createitem("Dr. Clef's Note", "paper", (arg0\Field3 + (846.0 * roomscale)), (arg0\Field4 + (210.0 * roomscale)), (arg0\Field5 + (320.0 * roomscale)), $00, $00, $00, 1.0, $00)
            entityparent(local6\Field1, arg0\Field2, $01)
            rotateentity(local6\Field1, 0.0, 0.0, 0.0, $00)
            arg0\Field19[$08] = copyentity(local11\Field6[$00], $00)
            scaleentity(arg0\Field19[$08], 0.0015, 0.0015, 0.0015, $00)
            positionentity(arg0\Field19[$08], (arg0\Field3 + (5335.0 * roomscale)), (arg0\Field4 + (1153.0 * roomscale)), (arg0\Field5 + (2176.0 * roomscale)), $00)
            entityparent(arg0\Field19[$08], arg0\Field2, $01)
            entitypickmode(arg0\Field19[$08], $01, $00)
            entityradius(arg0\Field19[$08], 0.1, 0.0)
            arg0\Field19[$09] = copyentity(local11\Field6[$01], $00)
            scaleentity(arg0\Field19[$09], 0.01, 0.01, 0.01, $00)
            positionentity(arg0\Field19[$09], (arg0\Field3 + (5335.0 * roomscale)), (arg0\Field4 + (399.0 * roomscale)), (arg0\Field5 + (2176.0 * roomscale)), $00)
            entityparent(arg0\Field19[$09], arg0\Field2, $01)
            entitypickmode(arg0\Field19[$09], $01, $00)
            entityradius(arg0\Field19[$09], 0.1, 0.0)
            rotateentity(arg0\Field19[$09], 0.0, rnd(360.0, 0.0), 90.0, $00)
        Case "room2scps"
            local0 = createdoor(arg0\Field0, (arg0\Field3 + (272.0 * roomscale)), arg0\Field4, arg0\Field5, 90.0, arg0, $01, $00, $05, "", $00)
            local0\Field21 = $00
            local0\Field5 = $00
            positionentity(local0\Field3[$00], (entityx(local0\Field3[$00], $01) + 0.061), entityy(local0\Field3[$00], $01), entityz(local0\Field3[$00], $01), $01)
            positionentity(local0\Field3[$01], (entityx(local0\Field3[$01], $01) - 0.061), entityy(local0\Field3[$01], $01), entityz(local0\Field3[$01], $01), $01)
            local0 = createdoor(arg0\Field0, (arg0\Field3 - (272.0 * roomscale)), arg0\Field4, arg0\Field5, 270.0, arg0, $01, $00, $05, "", $00)
            local0\Field21 = $00
            local0\Field5 = $00
            positionentity(local0\Field3[$00], (entityx(local0\Field3[$00], $01) - 0.061), entityy(local0\Field3[$00], $01), entityz(local0\Field3[$00], $01), $01)
            positionentity(local0\Field3[$01], (entityx(local0\Field3[$01], $01) + 0.061), entityy(local0\Field3[$01], $01), entityz(local0\Field3[$01], $01), $01)
            arg0\Field21[$01] = createdoor(arg0\Field0, (arg0\Field3 - (560.0 * roomscale)), 0.0, (arg0\Field5 - (272.0 * roomscale)), 0.0, arg0, $01, $00, $05, "", $00)
            arg0\Field21[$01]\Field21 = $00
            arg0\Field21[$01]\Field5 = $00
            arg0\Field21[$02] = createdoor(arg0\Field0, (arg0\Field3 + (560.0 * roomscale)), 0.0, (arg0\Field5 - (272.0 * roomscale)), 180.0, arg0, $01, $00, $05, "", $00)
            arg0\Field21[$02]\Field21 = $00
            arg0\Field21[$02]\Field5 = $00
            arg0\Field21[$03] = createdoor(arg0\Field0, (arg0\Field3 + (560.0 * roomscale)), 0.0, (arg0\Field5 + (272.0 * roomscale)), 180.0, arg0, $01, $00, $05, "", $00)
            arg0\Field21[$03]\Field21 = $00
            arg0\Field21[$03]\Field5 = $00
            arg0\Field21[$04] = createdoor(arg0\Field0, (arg0\Field3 - (560.0 * roomscale)), 0.0, (arg0\Field5 + (272.0 * roomscale)), 0.0, arg0, $01, $00, $05, "", $00)
            arg0\Field21[$04]\Field21 = $00
            arg0\Field21[$04]\Field5 = $00
            local6 = createitem("SCP-714", "scp714", (arg0\Field3 - (552.0 * roomscale)), (arg0\Field4 + (220.0 * roomscale)), (arg0\Field5 - (760.0 * roomscale)), $00, $00, $00, 1.0, $00)
            entityparent(local6\Field1, arg0\Field2, $01)
            local6 = createitem("SCP-1025", "scp1025", (arg0\Field3 + (552.0 * roomscale)), (arg0\Field4 + (224.0 * roomscale)), (arg0\Field5 - (758.0 * roomscale)), $00, $00, $00, 1.0, $00)
            entityparent(local6\Field1, arg0\Field2, $01)
            local6 = createitem("SCP-860", "scp860", (arg0\Field3 + (568.0 * roomscale)), (arg0\Field4 + (178.0 * roomscale)), (arg0\Field5 + (750.0 * roomscale)), $00, $00, $00, 1.0, $00)
            entityparent(local6\Field1, arg0\Field2, $01)
            For local7 = $00 To $03 Step $01
                Select local7
                    Case $00
                        local33 = 560.0
                        local34 = -372.0
                        local35 = 386.0
                        local36 = 180.0
                    Case $01
                        local33 = -560.0
                        local34 = -372.0
                        local35 = 386.0
                        local36 = 180.0
                    Case $02
                        local33 = 560.0
                        local34 = 372.0
                        local35 = 386.0
                        local36 = 0.0
                    Case $03
                        local33 = -560.0
                        local34 = 372.0
                        local35 = 386.0
                        local36 = 0.0
                End Select
                local2 = createsecuritycam((arg0\Field3 + (local33 * roomscale)), (arg0\Field4 + (local35 * roomscale)), (arg0\Field5 + (local34 * roomscale)), arg0, $00)
                local2\Field11 = local36
                local2\Field12 = 30.0
                turnentity(local2\Field3, 30.0, 0.0, 0.0, $00)
                entityparent(local2\Field0, arg0\Field2, $01)
            Next
            local6 = createitem("Document SCP-714", "paper", (arg0\Field3 - (728.0 * roomscale)), (arg0\Field4 + (288.0 * roomscale)), (arg0\Field5 - (360.0 * roomscale)), $00, $00, $00, 1.0, $00)
            entityparent(local6\Field1, arg0\Field2, $01)
            local6 = createitem("Document SCP-427", "paper", (arg0\Field3 - (608.0 * roomscale)), (arg0\Field4 + (66.0 * roomscale)), (arg0\Field5 + (636.0 * roomscale)), $00, $00, $00, 1.0, $00)
            entityparent(local6\Field1, arg0\Field2, $01)
            For local7 = $00 To $0E Step $01
                Select local7
                    Case $00
                        local28 = -64.0
                        local29 = -516.0
                    Case $01
                        local28 = -96.0
                        local29 = -388.0
                    Case $02
                        local28 = -128.0
                        local29 = -292.0
                    Case $03
                        local28 = -128.0
                        local29 = -132.0
                    Case $04
                        local28 = -160.0
                        local29 = -36.0
                    Case $05
                        local28 = -192.0
                        local29 = 28.0
                    Case $06
                        local28 = -384.0
                        local29 = 28.0
                    Case $07
                        local28 = -448.0
                        local29 = 92.0
                    Case $08
                        local28 = -480.0
                        local29 = 124.0
                    Case $09
                        local28 = -512.0
                        local29 = 156.0
                    Case $0A
                        local28 = -544.0
                        local29 = 220.0
                    Case $0B
                        local28 = -544.0
                        local29 = 380.0
                    Case $0C
                        local28 = -544.0
                        local29 = 476.0
                    Case $0D
                        local28 = -544.0
                        local29 = 572.0
                    Case $0E
                        local28 = -544.0
                        local29 = 636.0
                End Select
                local3 = createdecal(rand($0F, $10), (arg0\Field3 + (local28 * roomscale)), (arg0\Field4 + 0.005), (arg0\Field5 + (local29 * roomscale)), 90.0, (Float rand($168, $01)), 0.0)
                If (local7 > $0A) Then
                    local3\Field2 = rnd(0.2, 0.25)
                Else
                    local3\Field2 = rnd(0.1, 0.17)
                EndIf
                entityalpha(local3\Field0, 1.0)
                scalesprite(local3\Field0, local3\Field2, local3\Field2)
                entityparent(local3\Field0, arg0\Field2, $01)
            Next
        Case "room205"
            arg0\Field21[$01] = createdoor(arg0\Field0, (arg0\Field3 + (128.0 * roomscale)), arg0\Field4, (arg0\Field5 + (640.0 * roomscale)), 90.0, arg0, $01, $00, $05, "", $00)
            arg0\Field21[$01]\Field21 = $00
            arg0\Field21[$01]\Field5 = $00
            arg0\Field21[$00] = createdoor(arg0\Field0, (arg0\Field3 - (1392.0 * roomscale)), (arg0\Field4 - (128.0 * roomscale)), (arg0\Field5 - (384.0 * roomscale)), 0.0, arg0, $01, $00, $05, "", $01)
            arg0\Field21[$00]\Field21 = $00
            arg0\Field21[$00]\Field5 = $00
            freeentity(arg0\Field21[$00]\Field3[$00])
            arg0\Field21[$00]\Field3[$00] = $00
            freeentity(arg0\Field21[$00]\Field3[$01])
            arg0\Field21[$00]\Field3[$01] = $00
            local2 = createsecuritycam((arg0\Field3 - (1152.0 * roomscale)), (arg0\Field4 + (900.0 * roomscale)), (arg0\Field5 + (176.0 * roomscale)), arg0, $01)
            local2\Field11 = 90.0
            local2\Field12 = 0.0
            entityparent(local2\Field0, arg0\Field2, $01)
            local2\Field22 = $00
            local2\Field18 = 0.0
            entityparent(local2\Field4, $00, $01)
            positionentity(local2\Field4, (arg0\Field3 - (1716.0 * roomscale)), (arg0\Field4 + (160.0 * roomscale)), (arg0\Field5 + (176.0 * roomscale)), $01)
            turnentity(local2\Field4, 0.0, 90.0, 0.0, $00)
            scalesprite(local2\Field4, (448.0 * roomscale), (448.0 * roomscale))
            entityparent(local2\Field4, arg0\Field2, $01)
            camerazoom(local2\Field8, 1.5)
            hideentity(local2\Field10)
            hideentity(local2\Field1)
            arg0\Field19[$00] = createpivot($00)
            positionentity(arg0\Field19[$00], (arg0\Field3 - (1536.0 * roomscale)), (arg0\Field4 + (730.0 * roomscale)), (arg0\Field5 + (192.0 * roomscale)), $00)
            rotateentity(arg0\Field19[$00], 0.0, -90.0, 0.0, $00)
            entityparent(arg0\Field19[$00], arg0\Field2, $01)
            arg0\Field19[$01] = local2\Field4
        Case "endroom"
            arg0\Field21[$00] = createdoor(arg0\Field0, arg0\Field3, arg0\Field4, (arg0\Field5 + (1136.0 * roomscale)), 0.0, arg0, $00, $01, $06, "", $00)
            arg0\Field21[$00]\Field21 = $00
            arg0\Field21[$00]\Field5 = $00
            freeentity(arg0\Field21[$00]\Field3[$00])
            arg0\Field21[$00]\Field3[$00] = $00
            freeentity(arg0\Field21[$00]\Field3[$01])
            arg0\Field21[$00]\Field3[$01] = $00
        Case "room895"
            local0 = createdoor(arg0\Field0, arg0\Field3, 0.0, (arg0\Field5 - (448.0 * roomscale)), 0.0, arg0, $00, $01, $04, "", $00)
            local0\Field21 = $00
            local0\Field5 = $00
            positionentity(local0\Field3[$00], (arg0\Field3 - (390.0 * roomscale)), (arg0\Field4 + 0.7), (arg0\Field5 - (280.0 * roomscale)), $01)
            positionentity(local0\Field3[$01], (entityx(local0\Field3[$01], $01) + 0.025), entityy(local0\Field3[$01], $01), entityz(local0\Field3[$01], $01), $01)
            local2 = createsecuritycam((arg0\Field3 - (320.0 * roomscale)), (arg0\Field4 + (704.0 * roomscale)), (arg0\Field5 + (288.0 * roomscale)), arg0, $01)
            local2\Field11 = 225.0
            local2\Field12 = 45.0
            local2\Field21 = $01
            turnentity(local2\Field3, 120.0, 0.0, 0.0, $00)
            entityparent(local2\Field0, arg0\Field2, $01)
            coffincam = local2
            positionentity(local2\Field4, (arg0\Field3 - (800.0 * roomscale)), (arg0\Field4 + (288.0 * roomscale)), (arg0\Field5 - (340.0 * roomscale)), $00)
            entityparent(local2\Field4, arg0\Field2, $01)
            turnentity(local2\Field4, 0.0, 180.0, 0.0, $00)
            arg0\Field19[$02] = copyentity(local11\Field5[$00], $00)
            arg0\Field19[$03] = copyentity(local11\Field5[$01], $00)
            arg0\Field20[$00] = arg0\Field19[$03]
            For local7 = $00 To $01 Step $01
                scaleentity(arg0\Field19[($02 + local7)], 0.04, 0.04, 0.04, $00)
                positionentity(arg0\Field19[($02 + local7)], (arg0\Field3 - (800.0 * roomscale)), (arg0\Field4 + (180.0 * roomscale)), (arg0\Field5 - (336.0 * roomscale)), $01)
                entityparent(arg0\Field19[($02 + local7)], arg0\Field2, $01)
            Next
            rotateentity(arg0\Field19[$02], 0.0, 180.0, 0.0, $00)
            rotateentity(arg0\Field19[$03], 10.0, 0.0, 0.0, $00)
            entitypickmode(arg0\Field19[$03], $01, $00)
            entityradius(arg0\Field19[$03], 0.1, 0.0)
            arg0\Field19[$00] = createpivot(arg0\Field2)
            positionentity(arg0\Field19[$00], arg0\Field3, (arg0\Field4 - (1320.0 * roomscale)), (arg0\Field5 + (2304.0 * roomscale)), $00)
            local6 = createitem("Document SCP-895", "paper", (arg0\Field3 - (688.0 * roomscale)), (arg0\Field4 + (133.0 * roomscale)), (arg0\Field5 - (304.0 * roomscale)), $00, $00, $00, 1.0, $00)
            entityparent(local6\Field1, arg0\Field2, $01)
            local6 = createitem("Level 3 Key Card", "key3", (arg0\Field3 + (240.0 * roomscale)), (arg0\Field4 - (1456.0 * roomscale)), (arg0\Field5 + (2064.0 * roomscale)), $00, $00, $00, 1.0, $00)
            entityparent(local6\Field1, arg0\Field2, $01)
            local6 = createitem("Night Vision Goggles", "nvgoggles", (arg0\Field3 + (280.0 * roomscale)), (arg0\Field4 - (1456.0 * roomscale)), (arg0\Field5 + (2164.0 * roomscale)), $00, $00, $00, 1.0, $00)
            entityparent(local6\Field1, arg0\Field2, $01)
            local6\Field13 = 400.0
            arg0\Field19[$01] = createpivot($00)
            positionentity(arg0\Field19[$01], (arg0\Field3 + (96.0 * roomscale)), (arg0\Field4 - (1532.0 * roomscale)), (arg0\Field5 + (2016.0 * roomscale)), $00)
            entityparent(arg0\Field19[$01], arg0\Field2, $01)
        Case "room2tesla","room2tesla_lcz","room2tesla_hcz"
            arg0\Field19[$00] = createpivot($00)
            positionentity(arg0\Field19[$00], (arg0\Field3 - (114.0 * roomscale)), arg0\Field4, arg0\Field5, $00)
            entityparent(arg0\Field19[$00], arg0\Field2, $01)
            arg0\Field19[$01] = createpivot($00)
            positionentity(arg0\Field19[$01], (arg0\Field3 + (114.0 * roomscale)), arg0\Field4, arg0\Field5, $00)
            entityparent(arg0\Field19[$01], arg0\Field2, $01)
            arg0\Field19[$02] = createpivot($00)
            positionentity(arg0\Field19[$02], arg0\Field3, arg0\Field4, arg0\Field5, $00)
            entityparent(arg0\Field19[$02], arg0\Field2, $01)
            arg0\Field19[$03] = createsprite($00)
            entitytexture(arg0\Field19[$03], at\Field5[$0F], $00, $00)
            spriteviewmode(arg0\Field19[$03], $02)
            entityblend(arg0\Field19[$03], $03)
            entityfx(arg0\Field19[$03], $19)
            positionentity(arg0\Field19[$03], arg0\Field3, (arg0\Field4 + 0.8), arg0\Field5, $00)
            entityparent(arg0\Field19[$03], arg0\Field2, $01)
            hideentity(arg0\Field19[$03])
            local26 = createwaypoint(arg0\Field3, (arg0\Field4 + (66.0 * roomscale)), (arg0\Field5 + (292.0 * roomscale)), Null, arg0)
            local27 = createwaypoint(arg0\Field3, (arg0\Field4 + (66.0 * roomscale)), (arg0\Field5 - (284.0 * roomscale)), Null, arg0)
            local26\Field4[$00] = local27
            local26\Field5[$00] = entitydistance(local26\Field0, local27\Field0)
            local27\Field4[$00] = local26
            local27\Field5[$00] = local26\Field5[$00]
            arg0\Field19[$04] = createsprite($00)
            positionentity(arg0\Field19[$04], (arg0\Field3 - (32.0 * roomscale)), (arg0\Field4 + (568.0 * roomscale)), arg0\Field5, $00)
            scalesprite(arg0\Field19[$04], 0.03, 0.03)
            entitytexture(arg0\Field19[$04], at\Field3[$01], $00, $00)
            entityblend(arg0\Field19[$04], $03)
            entityparent(arg0\Field19[$04], arg0\Field2, $01)
            hideentity(arg0\Field19[$04])
            arg0\Field19[$05] = createpivot(arg0\Field2)
            positionentity(arg0\Field19[$05], arg0\Field3, arg0\Field4, (arg0\Field5 - (800.0 * roomscale)), $01)
            entityparent(arg0\Field19[$05], arg0\Field2, $01)
            arg0\Field19[$06] = createpivot(arg0\Field2)
            positionentity(arg0\Field19[$06], arg0\Field3, arg0\Field4, (arg0\Field5 + (800.0 * roomscale)), $01)
            entityparent(arg0\Field19[$06], arg0\Field2, $01)
            For local4 = Each rooms
                If (local4 <> arg0) Then
                    If ((((local4\Field7\Field10 = "room2tesla") Or (local4\Field7\Field10 = "room2tesla_lcz")) Or (local4\Field7\Field10 = "room2tesla_hcz")) <> 0) Then
                        arg0\Field19[$07] = copyentity(local4\Field19[$07], arg0\Field2)
                        Exit
                    EndIf
                EndIf
            Next
            If (arg0\Field19[$07] = $00) Then
                arg0\Field19[$07] = loadmesh_strict(scpmodding_processfilepath("GFX\map\room2tesla_caution.b3d"), arg0\Field2)
            EndIf
        Case "room2doors"
            local0 = createdoor(arg0\Field0, arg0\Field3, arg0\Field4, (arg0\Field5 + (528.0 * roomscale)), 0.0, arg0, $01, $00, $00, "", $00)
            local0\Field21 = $00
            positionentity(local0\Field3[$00], (arg0\Field3 - (832.0 * roomscale)), (arg0\Field4 + 0.7), (arg0\Field5 + (167.0 * roomscale)), $01)
            positionentity(local0\Field3[$01], entityx(local0\Field3[$01], $01), entityy(local0\Field3[$01], $01), (entityz(local0\Field3[$01], $01) - 0.061), $01)
            local1 = createdoor(arg0\Field0, arg0\Field3, 0.0, (arg0\Field5 - (528.0 * roomscale)), 180.0, arg0, $01, $00, $00, "", $00)
            local1\Field21 = $00
            freeentity(local1\Field3[$00])
            local1\Field3[$00] = $00
            positionentity(local1\Field3[$01], entityx(local1\Field3[$01], $01), entityy(local1\Field3[$01], $01), (entityz(local1\Field3[$01], $01) + 0.061), $01)
            arg0\Field19[$00] = createpivot($00)
            positionentity(arg0\Field19[$00], (arg0\Field3 - (832.0 * roomscale)), (arg0\Field4 + 0.5), arg0\Field5, $00)
            entityparent(arg0\Field19[$00], arg0\Field2, $01)
            local1\Field22 = local0
            local0\Field22 = local1
            local0\Field5 = $00
            local1\Field5 = $01
        Case "room914"
            arg0\Field21[$02] = createdoor(arg0\Field0, arg0\Field3, arg0\Field4, (arg0\Field5 - (368.0 * roomscale)), 0.0, arg0, $00, $01, $04, "", $00)
            arg0\Field21[$02]\Field9 = $01
            arg0\Field21[$02]\Field21 = $00
            positionentity(arg0\Field21[$02]\Field3[$00], (arg0\Field3 - (496.0 * roomscale)), entityy(arg0\Field21[$02]\Field3[$00], $01), (arg0\Field5 - (278.0 * roomscale)), $01)
            positionentity(arg0\Field21[$02]\Field3[$01], (entityx(arg0\Field21[$02]\Field3[$01], $01) + 0.025), entityy(arg0\Field21[$02]\Field3[$01], $01), entityz(arg0\Field21[$02]\Field3[$01], $01), $01)
            turnentity(arg0\Field21[$02]\Field3[$00], 0.0, 90.0, 0.0, $00)
            local0 = createdoor(arg0\Field0, (arg0\Field3 - (1036.0 * roomscale)), arg0\Field4, (arg0\Field5 + (528.0 * roomscale)), 180.0, arg0, $01, $00, $00, "", $00)
            freeentity(local0\Field1)
            local0\Field1 = $00
            freeentity(local0\Field3[$00])
            local0\Field3[$00] = $00
            freeentity(local0\Field3[$01])
            local0\Field3[$01] = $00
            local0\Field9 = $04
            arg0\Field21[$00] = local0
            local0\Field21 = $00
            local0 = createdoor(arg0\Field0, (arg0\Field3 + (404.0 * roomscale)), arg0\Field4, (arg0\Field5 + (528.0 * roomscale)), 180.0, arg0, $01, $00, $00, "", $00)
            freeentity(local0\Field1)
            local0\Field1 = $00
            freeentity(local0\Field3[$00])
            local0\Field3[$00] = $00
            freeentity(local0\Field3[$01])
            local0\Field3[$01] = $00
            local0\Field9 = $04
            arg0\Field21[$01] = local0
            local0\Field21 = $00
            arg0\Field21[$03] = createdoor(arg0\Field0, (arg0\Field3 - (448.0 * roomscale)), arg0\Field4, (arg0\Field5 - (705.0 * roomscale)), 90.0, arg0, $00, $00, $04, "", $00)
            positionentity(arg0\Field21[$03]\Field3[$00], (entityx(arg0\Field21[$03]\Field3[$00], $01) - 0.061), entityy(arg0\Field21[$03]\Field3[$00], $01), entityz(arg0\Field21[$03]\Field3[$00], $01), $01)
            positionentity(arg0\Field21[$03]\Field3[$01], (entityx(arg0\Field21[$03]\Field3[$01], $01) + 0.061), entityy(arg0\Field21[$03]\Field3[$01], $01), entityz(arg0\Field21[$03]\Field3[$01], $01), $01)
            If (arg0\Field19[$00] = $00) Then
                arg0\Field19[$00] = loadmesh_strict(scpmodding_processfilepath("GFX\map\914key.x"), arg0\Field2)
            EndIf
            positionentity(arg0\Field19[$00], (arg0\Field3 - (416.0 * roomscale)), (arg0\Field4 + (190.0 * roomscale)), (arg0\Field5 + (374.0 * roomscale)), $01)
            If (arg0\Field19[$01] = $00) Then
                arg0\Field19[$01] = loadmesh_strict(scpmodding_processfilepath("GFX\map\914knob.x"), arg0\Field2)
            EndIf
            positionentity(arg0\Field19[$01], (arg0\Field3 - (416.0 * roomscale)), (arg0\Field4 + (230.0 * roomscale)), (arg0\Field5 + (374.0 * roomscale)), $01)
            For local7 = $00 To $01 Step $01
                scaleentity(arg0\Field19[local7], roomscale, roomscale, roomscale, $01)
                entitypickmode(arg0\Field19[local7], $02, $01)
            Next
            arg0\Field19[$02] = createpivot($00)
            positionentity(arg0\Field19[$02], (arg0\Field3 - (1132.0 * roomscale)), (arg0\Field4 + 0.5), (arg0\Field5 + (640.0 * roomscale)), $00)
            entityparent(arg0\Field19[$02], arg0\Field2, $01)
            arg0\Field19[$03] = createpivot($00)
            positionentity(arg0\Field19[$03], (arg0\Field3 + (308.0 * roomscale)), (arg0\Field4 + 0.5), (arg0\Field5 + (640.0 * roomscale)), $00)
            entityparent(arg0\Field19[$03], arg0\Field2, $01)
            local6 = createitem("Addendum: 5/14 Test Log", "paper", (arg0\Field3 + (538.0 * roomscale)), (arg0\Field4 + (228.0 * roomscale)), (arg0\Field5 + (127.0 * roomscale)), $00, $00, $00, 1.0, $00)
            entityparent(local6\Field1, arg0\Field2, $01)
            rotateentity(local6\Field1, 0.0, 0.0, 0.0, $00)
            local6 = createitem("First Aid Kit", "firstaid", (arg0\Field3 + (538.0 * roomscale)), (arg0\Field4 + (112.0 * roomscale)), (arg0\Field5 - (40.0 * roomscale)), $00, $00, $00, 1.0, $00)
            entityparent(local6\Field1, arg0\Field2, $01)
            rotateentity(local6\Field1, 0.0, 90.0, 0.0, $00)
            local6 = createitem("Dr. L's Note", "paper", (arg0\Field3 - (538.0 * roomscale)), (arg0\Field4 + (250.0 * roomscale)), (arg0\Field5 - (365.0 * roomscale)), $00, $00, $00, 1.0, $00)
            entityparent(local6\Field1, arg0\Field2, $01)
        Case "room173intro"
            arg0\Field19[$00] = createpivot($00)
            positionentity(arg0\Field19[$00], (entityx(arg0\Field2, $00) + (40.0 * roomscale)), (arg0\Field4 + (460.0 * roomscale)), (entityz(arg0\Field2, $00) + (1072.0 * roomscale)), $00)
            entityparent(arg0\Field19[$00], arg0\Field2, $01)
            arg0\Field19[$01] = createpivot($00)
            positionentity(arg0\Field19[$01], (entityx(arg0\Field2, $00) - (80.0 * roomscale)), (arg0\Field4 + (100.0 * roomscale)), (entityz(arg0\Field2, $00) + (526.0 * roomscale)), $00)
            entityparent(arg0\Field19[$01], arg0\Field2, $01)
            arg0\Field19[$02] = createpivot($00)
            positionentity(arg0\Field19[$02], (entityx(arg0\Field2, $00) - (128.0 * roomscale)), (arg0\Field4 + (100.0 * roomscale)), (entityz(arg0\Field2, $00) + (320.0 * roomscale)), $00)
            entityparent(arg0\Field19[$02], arg0\Field2, $01)
            arg0\Field19[$03] = createpivot($00)
            positionentity(arg0\Field19[$03], (entityx(arg0\Field2, $00) + (660.0 * roomscale)), (arg0\Field4 + (100.0 * roomscale)), (entityz(arg0\Field2, $00) + (526.0 * roomscale)), $00)
            entityparent(arg0\Field19[$03], arg0\Field2, $01)
            arg0\Field19[$04] = createpivot($00)
            positionentity(arg0\Field19[$04], (entityx(arg0\Field2, $00) + (700.0 * roomscale)), (arg0\Field4 + (100.0 * roomscale)), (entityz(arg0\Field2, $00) + (320.0 * roomscale)), $00)
            entityparent(arg0\Field19[$04], arg0\Field2, $01)
            arg0\Field19[$05] = createpivot($00)
            positionentity(arg0\Field19[$05], (entityx(arg0\Field2, $00) + (1472.0 * roomscale)), (arg0\Field4 + (100.0 * roomscale)), (entityz(arg0\Field2, $00) + (912.0 * roomscale)), $00)
            entityparent(arg0\Field19[$05], arg0\Field2, $01)
            arg0\Field21[$01] = createdoor(arg0\Field0, (entityx(arg0\Field2, $00) + (288.0 * roomscale)), arg0\Field4, (entityz(arg0\Field2, $00) + (384.0 * roomscale)), 90.0, arg0, $00, $01, $00, "", $00)
            arg0\Field21[$01]\Field21 = $00
            arg0\Field21[$01]\Field9 = $01
            arg0\Field21[$01]\Field5 = $00
            freeentity(arg0\Field21[$01]\Field3[$00])
            arg0\Field21[$01]\Field3[$00] = $00
            freeentity(arg0\Field21[$01]\Field3[$01])
            arg0\Field21[$01]\Field3[$01] = $00
            For local7 = $00 To $04 Step $01
                Select local7
                    Case $00
                        local28 = 1472.0
                        local29 = 912.0
                        local30 = 1.2
                        local31 = $04
                    Case $01
                        local28 = 1504.0
                        local29 = -80.0
                        local30 = 0.54
                        local31 = $04
                    Case $02
                        local28 = 587.0
                        local29 = -70.0
                        local30 = 0.44
                        local31 = $04
                    Case $03
                        local28 = 602.0
                        local29 = 642.0
                        local30 = 0.54
                        local31 = $04
                    Case $04
                        local28 = 1260.0
                        local29 = 627.0
                        local30 = 0.54
                        local31 = $06
                End Select
                local3 = createdecal(local31, (arg0\Field3 + (local28 * roomscale)), (arg0\Field4 + (2.0 * roomscale)), (arg0\Field5 + (local29 * roomscale)), 90.0, 45.0, 0.0)
                local3\Field2 = local30
                local3\Field5 = rnd(0.8, 1.0)
                scalesprite(local3\Field0, local3\Field2, local3\Field2)
            Next
            arg0\Field21[$02] = createdoor(arg0\Field0, (arg0\Field3 - (1008.0 * roomscale)), arg0\Field4, (arg0\Field5 - (688.0 * roomscale)), 90.0, arg0, $01, $00, $00, "", $01)
            arg0\Field21[$02]\Field21 = $00
            arg0\Field21[$02]\Field5 = $00
            arg0\Field21[$02]\Field4 = $01
            freeentity(arg0\Field21[$02]\Field3[$00])
            arg0\Field21[$02]\Field3[$00] = $00
            freeentity(arg0\Field21[$02]\Field3[$01])
            arg0\Field21[$02]\Field3[$01] = $00
            arg0\Field21[$03] = createdoor(arg0\Field0, (arg0\Field3 - (2324.0 * roomscale)), arg0\Field4, (arg0\Field5 - (1248.0 * roomscale)), 90.0, arg0, $01, $00, $00, "", $00)
            arg0\Field21[$03]\Field21 = $00
            arg0\Field21[$03]\Field5 = $01
            arg0\Field21[$03]\Field4 = $01
            positionentity(arg0\Field21[$03]\Field3[$00], (entityx(arg0\Field21[$03]\Field3[$00], $01) - (4.0 * roomscale)), entityy(arg0\Field21[$03]\Field3[$00], $01), entityz(arg0\Field21[$03]\Field3[$00], $01), $01)
            positionentity(arg0\Field21[$03]\Field3[$01], (entityx(arg0\Field21[$03]\Field3[$01], $01) + (4.0 * roomscale)), entityy(arg0\Field21[$03]\Field3[$01], $01), entityz(arg0\Field21[$03]\Field3[$01], $01), $01)
            arg0\Field21[$04] = createdoor(arg0\Field0, (arg0\Field3 - (4352.0 * roomscale)), arg0\Field4, (arg0\Field5 - (1248.0 * roomscale)), 90.0, arg0, $01, $00, $00, "", $00)
            arg0\Field21[$04]\Field21 = $00
            arg0\Field21[$04]\Field5 = $01
            arg0\Field21[$04]\Field4 = $01
            arg0\Field21[$07] = createdoor(arg0\Field0, (arg0\Field3 - (3712.0 * roomscale)), (arg0\Field4 - (385.0 * roomscale)), (arg0\Field5 - (128.0 * roomscale)), 0.0, arg0, $01, $00, $00, "", $00)
            arg0\Field21[$07]\Field21 = $00
            arg0\Field21[$07]\Field5 = $01
            freeentity(arg0\Field21[$07]\Field3[$01])
            arg0\Field21[$07]\Field3[$01] = $00
            local0 = createdoor(arg0\Field0, (arg0\Field3 - (3712.0 * roomscale)), (arg0\Field4 - (385.0 * roomscale)), (arg0\Field5 - (2336.0 * roomscale)), 0.0, arg0, $00, $00, $00, "", $00)
            local0\Field4 = $01
            local0\Field14 = $01
            freeentity(local0\Field3[$00])
            local0\Field3[$00] = $00
            local0 = createdoor(arg0\Field0, (arg0\Field3 - (6864.0 * roomscale)), arg0\Field4, (arg0\Field5 - (1248.0 * roomscale)), 90.0, arg0, $01, $00, $00, "", $00)
            local0\Field21 = $00
            local0\Field4 = $01
            local0 = createdoor(arg0\Field0, (arg0\Field3 - (2432.0 * roomscale)), arg0\Field4, (arg0\Field5 - (1000.0 * roomscale)), 0.0, arg0, $00, $00, $00, "", $00)
            positionentity(local0\Field3[$00], (arg0\Field3 - (2592.0 * roomscale)), entityy(local0\Field3[$00], $01), (arg0\Field5 - (1010.0 * roomscale)), $01)
            freeentity(local0\Field3[$01])
            local0\Field3[$01] = $00
            local0\Field4 = $01
            local0\Field14 = $01
            local23 = loadtexture_strict(scpmodding_processfilepath("GFX\map\Door02.jpg"), $01)
            For local10 = $00 To $01 Step $01
                local0 = createdoor(arg0\Field0, (arg0\Field3 - (5760.0 * roomscale)), 0.0, (arg0\Field5 + ((Float (($380 * local10) + $140)) * roomscale)), 0.0, arg0, $00, $00, $00, "", $00)
                local0\Field4 = $01
                local0\Field14 = $01
                If (local10 = $00) Then
                    freeentity(local0\Field3[$00])
                    local0\Field3[$00] = $00
                Else
                    freeentity(local0\Field3[$01])
                    local0\Field3[$01] = $00
                EndIf
                local0 = createdoor(arg0\Field0, (arg0\Field3 - (8288.0 * roomscale)), 0.0, (arg0\Field5 + ((Float (($380 * local10) + $140)) * roomscale)), 0.0, arg0, $00, $00, $00, "", $00)
                local0\Field4 = $01
                If (local10 = $00) Then
                    local0\Field5 = $01
                Else
                    local0\Field14 = $01
                    freeentity(local0\Field3[$01])
                    local0\Field3[$01] = $00
                EndIf
                For local8 = $00 To $02 Step $01
                    local0 = createdoor(arg0\Field0, (arg0\Field3 - ((7424.0 - (512.0 * (Float local8))) * roomscale)), 0.0, (arg0\Field5 + ((1008.0 - (480.0 * (Float local10))) * roomscale)), (Float ((local10 = $00) * $B4)), arg0, $00, $00, $00, "", $00)
                    entitytexture(local0\Field0, local23, $00, $00)
                    local0\Field4 = $01
                    freeentity(local0\Field1)
                    local0\Field1 = $00
                    freeentity(local0\Field3[$00])
                    local0\Field3[$00] = $00
                    freeentity(local0\Field3[$01])
                    local0\Field3[$01] = $00
                    local0\Field14 = $01
                Next
                For local8 = $00 To $04 Step $01
                    local0 = createdoor(arg0\Field0, (arg0\Field3 - ((5120.0 - (512.0 * (Float local8))) * roomscale)), 0.0, (arg0\Field5 + ((1008.0 - (480.0 * (Float local10))) * roomscale)), (Float ((local10 = $00) * $B4)), arg0, $00, $00, $00, "", $00)
                    entitytexture(local0\Field0, local23, $00, $00)
                    local0\Field4 = $01
                    freeentity(local0\Field1)
                    local0\Field1 = $00
                    freeentity(local0\Field3[$00])
                    local0\Field3[$00] = $00
                    freeentity(local0\Field3[$01])
                    local0\Field3[$01] = $00
                    local0\Field14 = $01
                    If (((local8 = $02) And (local10 = $01)) <> 0) Then
                        arg0\Field21[$06] = local0
                    EndIf
                Next
            Next
            createitem("Class D Orientation Leaflet", "paper", (arg0\Field3 - (3938.0 * roomscale)), (arg0\Field4 + (170.0 * roomscale)), (arg0\Field5 + (40.0 * roomscale)), $00, $00, $00, 1.0, $00)
            local2 = createsecuritycam((arg0\Field3 - (4048.0 * roomscale)), (arg0\Field4 - (32.0 * roomscale)), (arg0\Field5 - (1232.0 * roomscale)), arg0, $01)
            local2\Field11 = 270.0
            local2\Field12 = 45.0
            local2\Field19 = arg0
            turnentity(local2\Field3, 20.0, 0.0, 0.0, $00)
            entityparent(local2\Field0, arg0\Field2, $01)
            positionentity(local2\Field4, (arg0\Field3 - (2256.0 * roomscale)), (arg0\Field4 + (224.0 * roomscale)), (arg0\Field5 - (928.0 * roomscale)), $00)
            turnentity(local2\Field4, 0.0, 90.0, 0.0, $00)
            entityparent(local2\Field4, arg0\Field2, $01)
            If (arg0\Field19[$09] = $00) Then
                arg0\Field19[$09] = loadmesh_strict(scpmodding_processfilepath("GFX\map\173_2.b3d"), arg0\Field2)
            EndIf
            entitytype(arg0\Field19[$09], $01, $00)
            entitypickmode(arg0\Field19[$09], $02, $01)
            If (arg0\Field19[$0A] = $00) Then
                arg0\Field19[$0A] = loadmesh_strict(scpmodding_processfilepath("GFX\map\intro_labels.b3d"), arg0\Field2)
            EndIf
            positionentity(arg0\Field19[$0A], entityx(arg0\Field19[$0A], $01), (entityy(arg0\Field19[$0A], $01) - (10.0 * roomscale)), entityz(arg0\Field19[$0A], $01), $01)
            arg0\Field19[$0B] = createpivot($00)
            positionentity(arg0\Field19[$0B], (entityx(arg0\Field2, $00) - (7200.0 * roomscale)), -0.3, (entityz(arg0\Field2, $00) - (3075.0 * roomscale)), $00)
            entityparent(arg0\Field19[$0B], arg0\Field2, $01)
            local2 = createsecuritycam((entityx(arg0\Field2, $00) + (1628.0 * roomscale)), (arg0\Field4 + (768.0 * roomscale)), (entityz(arg0\Field2, $00) + (866.0 * roomscale)), arg0, $01)
            local2\Field11 = -223.0
            local2\Field12 = 45.0
            local2\Field19 = arg0
            turnentity(local2\Field3, 30.0, 0.0, 0.0, $00)
            entityparent(local2\Field0, arg0\Field2, $01)
        Case "room2ccont"
            local0 = createdoor(arg0\Field0, (arg0\Field3 + (64.0 * roomscale)), arg0\Field4, (arg0\Field5 + (368.0 * roomscale)), 0.0, arg0, $00, $00, $04, "", $00)
            local0\Field21 = $00
            local0\Field5 = $00
            positionentity(local0\Field3[$00], entityx(local0\Field3[$00], $01), entityy(local0\Field3[$00], $01), (entityz(local0\Field3[$00], $01) + 0.061), $01)
            positionentity(local0\Field3[$01], entityx(local0\Field3[$01], $01), entityy(local0\Field3[$01], $01), (entityz(local0\Field3[$01], $01) - 0.061), $01)
            local6 = createitem("Note from Daniel", "paper", (arg0\Field3 - (400.0 * roomscale)), (arg0\Field4 + (1040.0 * roomscale)), (arg0\Field5 + (115.0 * roomscale)), $00, $00, $00, 1.0, $00)
            entityparent(local6\Field1, arg0\Field2, $01)
            For local17 = $00 To $02 Step $01
                arg0\Field19[(local17 Shl $01)] = copyentity(local11\Field5[$00], $00)
                arg0\Field19[((local17 Shl $01) + $01)] = copyentity(local11\Field5[$01], $00)
                arg0\Field20[local17] = arg0\Field19[((local17 Shl $01) + $01)]
                For local7 = $00 To $01 Step $01
                    scaleentity(arg0\Field19[((local17 Shl $01) + local7)], 0.04, 0.04, 0.04, $00)
                    positionentity(arg0\Field19[((local17 Shl $01) + local7)], (arg0\Field3 - (240.0 * roomscale)), (arg0\Field4 + (1104.0 * roomscale)), (arg0\Field5 + ((632.0 - (64.0 * (Float local17))) * roomscale)), $01)
                    entityparent(arg0\Field19[((local17 Shl $01) + local7)], arg0\Field2, $01)
                Next
                rotateentity(arg0\Field19[(local17 Shl $01)], 0.0, -90.0, 0.0, $00)
                rotateentity(arg0\Field19[((local17 Shl $01) + $01)], 10.0, -270.0, 0.0, $00)
                entitypickmode(arg0\Field19[((local17 Shl $01) + $01)], $01, $00)
                entityradius(arg0\Field19[((local17 Shl $01) + $01)], 0.1, 0.0)
            Next
            local2 = createsecuritycam((arg0\Field3 - (265.0 * roomscale)), (arg0\Field4 + (1280.0 * roomscale)), (arg0\Field5 + (105.0 * roomscale)), arg0, $00)
            local2\Field11 = 45.0
            local2\Field12 = 45.0
            turnentity(local2\Field3, 20.0, 0.0, 0.0, $00)
        Case "room106"
            local6 = createitem("Level 5 Key Card", "key5", (arg0\Field3 - (752.0 * roomscale)), (arg0\Field4 - (7920.0 * roomscale)), (arg0\Field5 + (2962.0 * roomscale)), $00, $00, $00, 1.0, $00)
            entityparent(local6\Field1, arg0\Field2, $01)
            local6 = createitem("Dr. Allok's Note", "paper", (arg0\Field3 - (416.0 * roomscale)), (arg0\Field4 - (7904.0 * roomscale)), (arg0\Field5 + (2428.0 * roomscale)), $00, $00, $00, 1.0, $00)
            entityparent(local6\Field1, arg0\Field2, $01)
            local6 = createitem("Recall Protocol RP-106-N", "paper", (arg0\Field3 + (268.0 * roomscale)), (arg0\Field4 - (7904.0 * roomscale)), (arg0\Field5 + (2529.0 * roomscale)), $00, $00, $00, 1.0, $00)
            entityparent(local6\Field1, arg0\Field2, $01)
            arg0\Field21[$00] = createdoor(arg0\Field0, (arg0\Field3 - (647.0 * roomscale)), (arg0\Field4 - (7327.9 * roomscale)), (arg0\Field5 - (803.0 * roomscale)), 90.0, arg0, $00, $03, $00, "", $00)
            arg0\Field21[$00]\Field21 = $00
            arg0\Field21[$00]\Field5 = $00
            positionentity(arg0\Field21[$00]\Field3[$00], (entityx(arg0\Field21[$00]\Field3[$00], $01) + 0.03), entityy(arg0\Field21[$00]\Field3[$00], $01), entityz(arg0\Field21[$00]\Field3[$00], $01), $01)
            positionentity(arg0\Field21[$00]\Field3[$01], (entityx(arg0\Field21[$00]\Field3[$01], $01) - 0.03), entityy(arg0\Field21[$00]\Field3[$01], $01), entityz(arg0\Field21[$00]\Field3[$01], $01), $01)
            arg0\Field21[$01] = createdoor(arg0\Field0, (arg0\Field3 - (708.0 * roomscale)), arg0\Field4, (arg0\Field5 - (704.0 * roomscale)), 90.0, arg0, $01, $03, $00, "", $00)
            arg0\Field21[$01]\Field21 = $00
            positionentity(arg0\Field21[$01]\Field3[$00], (entityx(arg0\Field21[$01]\Field3[$00], $01) + 0.018), entityy(arg0\Field21[$01]\Field3[$00], $01), entityz(arg0\Field21[$01]\Field3[$00], $01), $01)
            positionentity(arg0\Field21[$01]\Field3[$01], (entityx(arg0\Field21[$01]\Field3[$01], $01) - 0.018), entityy(arg0\Field21[$01]\Field3[$01], $01), entityz(arg0\Field21[$01]\Field3[$01], $01), $01)
            local0 = createdoor(arg0\Field0, (arg0\Field3 - (968.0 * roomscale)), (arg0\Field4 - (8092.0 * roomscale)), (arg0\Field5 + (1328.0 * roomscale)), 0.0, arg0, $00, $00, $06, "", $00)
            local0\Field21 = $00
            local0\Field5 = $00
            positionentity(local0\Field3[$00], entityx(local0\Field3[$00], $01), entityy(local0\Field3[$00], $01), (entityz(local0\Field3[$00], $01) + 0.061), $01)
            positionentity(local0\Field3[$01], entityx(local0\Field3[$01], $01), entityy(local0\Field3[$01], $01), (entityz(local0\Field3[$01], $01) - 0.061), $01)
            local0 = createdoor(arg0\Field0, arg0\Field3, (arg0\Field4 - (7328.0 * roomscale)), (arg0\Field5 - (529.0 * roomscale)), 0.0, arg0, $00, $00, $06, "", $00)
            local0\Field21 = $00
            local0\Field5 = $00
            positionentity(local0\Field3[$00], entityx(local0\Field3[$00], $01), entityy(local0\Field3[$00], $01), (entityz(local0\Field3[$00], $01) + 0.03), $01)
            positionentity(local0\Field3[$01], entityx(local0\Field3[$01], $01), entityy(local0\Field3[$01], $01), (entityz(local0\Field3[$01], $01) - 0.03), $01)
            local0 = createdoor(arg0\Field0, (arg0\Field3 - (624.0 * roomscale)), (arg0\Field4 - (8608.0 * roomscale)), (arg0\Field5 - (64.0 * roomscale)), 90.0, arg0, $00, $00, $06, "", $00)
            local0\Field21 = $00
            local0\Field5 = $00
            positionentity(local0\Field3[$00], (entityx(local0\Field3[$00], $01) - 0.03), entityy(local0\Field3[$00], $01), entityz(local0\Field3[$00], $01), $01)
            positionentity(local0\Field3[$01], (entityx(local0\Field3[$01], $01) + 0.03), entityy(local0\Field3[$01], $01), entityz(local0\Field3[$01], $01), $01)
            local0 = createdoor(arg0\Field0, (arg0\Field3 - (176.0 * roomscale)), (arg0\Field4 - (7328.0 * roomscale)), (arg0\Field5 - (1697.0 * roomscale)), 0.0, arg0, $00, $02, $00, "", $00)
            local0\Field21 = $00
            local0\Field5 = $00
            local0\Field4 = $01
            local0\Field14 = $01
            local0\Field24 = $00
            positionentity(local0\Field3[$01], entityx(local0\Field3[$01], $01), entityy(local0\Field3[$01], $01), (entityz(local0\Field3[$01], $01) - 0.03), $01)
            freeentity(local0\Field3[$00])
            local0\Field3[$00] = $00
            local0 = createdoor(arg0\Field0, (arg0\Field3 + (384.0 * roomscale)), arg0\Field4, (arg0\Field5 - (704.0 * roomscale)), 90.0, arg0, $00, $02, $00, "", $00)
            local0\Field21 = $00
            local0\Field5 = $00
            local0\Field4 = $01
            local0\Field14 = $01
            local0\Field24 = $00
            positionentity(local0\Field3[$01], entityx(local0\Field3[$01], $01), entityy(local0\Field3[$01], $01), (entityz(local0\Field3[$01], $01) - 0.03), $01)
            freeentity(local0\Field3[$00])
            local0\Field3[$00] = $00
            If (arg0\Field19[$06] = $00) Then
                arg0\Field19[$06] = loadmesh_strict(scpmodding_processfilepath("GFX\map\room1062.b3d"), $00)
            EndIf
            scaleentity(arg0\Field19[$06], roomscale, roomscale, roomscale, $00)
            entitytype(arg0\Field19[$06], $01, $00)
            entitypickmode(arg0\Field19[$06], $03, $01)
            positionentity(arg0\Field19[$06], (arg0\Field3 + (784.0 * roomscale)), (arg0\Field4 - (8308.0 * roomscale)), (arg0\Field5 + (656.0 * roomscale)), $00)
            entityparent(arg0\Field19[$06], arg0\Field2, $01)
            For local17 = $00 To $02 Step $02
                arg0\Field19[local17] = copyentity(local11\Field5[$00], $00)
                arg0\Field19[(local17 + $01)] = copyentity(local11\Field5[$01], $00)
                arg0\Field20[(local17 Sar $01)] = arg0\Field19[(local17 + $01)]
                For local7 = $00 To $01 Step $01
                    scaleentity(arg0\Field19[(local17 + local7)], 0.04, 0.04, 0.04, $00)
                    positionentity(arg0\Field19[(local17 + local7)], (arg0\Field3 - ((555.0 - (81.0 * (Float (local17 Sar $01)))) * roomscale)), (arg0\Field4 - (7904.0 * roomscale)), (arg0\Field5 + (2976.0 * roomscale)), $01)
                    entityparent(arg0\Field19[(local17 + local7)], arg0\Field2, $01)
                Next
                rotateentity(arg0\Field19[local17], 0.0, 0.0, 0.0, $00)
                rotateentity(arg0\Field19[(local17 + $01)], 10.0, -180.0, 0.0, $00)
                entitypickmode(arg0\Field19[(local17 + $01)], $01, $00)
                entityradius(arg0\Field19[(local17 + $01)], 0.1, 0.0)
            Next
            rotateentity(arg0\Field19[$01], 81.0, -180.0, 0.0, $00)
            rotateentity(arg0\Field19[$03], -81.0, -180.0, 0.0, $00)
            arg0\Field19[$04] = createbutton((arg0\Field3 - (146.0 * roomscale)), (arg0\Field4 - (7904.0 * roomscale)), (arg0\Field5 + (2989.0 * roomscale)), 0.0, 0.0, 0.0, $00)
            entityparent(arg0\Field19[$04], arg0\Field2, $01)
            local2 = createsecuritycam((arg0\Field3 + (768.0 * roomscale)), (arg0\Field4 - (5936.0 * roomscale)), (arg0\Field5 + (1632.0 * roomscale)), arg0, $01)
            local2\Field11 = 315.0
            local2\Field12 = 20.0
            turnentity(local2\Field3, 45.0, 0.0, 0.0, $00)
            entityparent(local2\Field0, arg0\Field2, $01)
            arg0\Field19[$07] = local2\Field3
            arg0\Field19[$08] = local2\Field0
            positionentity(local2\Field4, (arg0\Field3 - (272.0 * roomscale)), (arg0\Field4 - (7872.0 * roomscale)), (arg0\Field5 + (2956.0 * roomscale)), $00)
            turnentity(local2\Field4, 0.0, -10.0, 0.0, $00)
            entityparent(local2\Field4, arg0\Field2, $01)
            local2\Field21 = $00
            local2 = createsecuritycam((arg0\Field3 - (1216.0 * roomscale)), (arg0\Field4 - (7664.0 * roomscale)), (arg0\Field5 + (1404.0 * roomscale)), arg0, $01)
            local2\Field11 = 315.0
            local2\Field12 = 30.0
            local2\Field19 = arg0
            turnentity(local2\Field3, 20.0, 0.0, 0.0, $00)
            entityparent(local2\Field0, arg0\Field2, $01)
            arg0\Field19[$05] = createpivot($00)
            turnentity(arg0\Field19[$05], 0.0, 180.0, 0.0, $00)
            positionentity(arg0\Field19[$05], (arg0\Field3 + (1088.0 * roomscale)), (arg0\Field4 - (6224.0 * roomscale)), (arg0\Field5 + (1824.0 * roomscale)), $00)
            entityparent(arg0\Field19[$05], arg0\Field2, $01)
            arg0\Field19[$09] = createpivot($00)
            positionentity(arg0\Field19[$09], (arg0\Field3 - (272.0 * roomscale)), (arg0\Field4 - (8000.0 * roomscale)), (arg0\Field5 + (2672.0 * roomscale)), $00)
            entityparent(arg0\Field19[$09], arg0\Field2, $01)
            arg0\Field19[$0A] = createpivot($00)
            positionentity(arg0\Field19[$0A], arg0\Field3, (arg0\Field4 - (7325.0 * roomscale)), (arg0\Field5 - (784.0 * roomscale)), $00)
            entityparent(arg0\Field19[$0A], arg0\Field2, $01)
            arg0\Field19[$0B] = createpivot($00)
            positionentity(arg0\Field19[$0B], (arg0\Field3 - (944.0 * roomscale)), (arg0\Field4 - (7088.0 * roomscale)), (arg0\Field5 - (803.0 * roomscale)), $00)
            entityparent(arg0\Field19[$0B], arg0\Field2, $01)
            arg0\Field19[$0C] = createpivot($00)
            positionentity(arg0\Field19[$0C], (arg0\Field3 - (1000.0 * roomscale)), (arg0\Field4 + (240.0 * roomscale)), (arg0\Field5 - (704.0 * roomscale)), $00)
            entityparent(arg0\Field19[$0C], arg0\Field2, $01)
        Case "room1archive"
            For local8 = $00 To $01 Step $01
                For local9 = $00 To $02 Step $01
                    For local10 = $00 To $02 Step $01
                        local40 = "9V Battery"
                        local41 = "bat"
                        local42 = rand($FFFFFFF6, $64)
                        Select $01
                            Case (local42 < $00)
                                Exit
                            Case (local42 < $28)
                                local40 = "Document SCP-"
                                Select rand($01, $20)
                                    Case $01
                                        local40 = (local40 + "1123")
                                    Case $02
                                        local40 = (local40 + "1048")
                                    Case $03
                                        local40 = (local40 + "939")
                                    Case $04
                                        local40 = (local40 + "682")
                                    Case $05
                                        local40 = (local40 + "079")
                                    Case $06
                                        local40 = (local40 + "096")
                                    Case $07
                                        local40 = (local40 + "966")
                                    Case $08
                                        local40 = (local40 + "1079")
                                    Case $09
                                        local40 = (local40 + "650")
                                    Case $0A
                                        local40 = (local40 + "008")
                                    Case $0B
                                        local40 = (local40 + "1162")
                                    Case $0C
                                        local40 = (local40 + "1123")
                                    Case $0D
                                        local40 = (local40 + "215")
                                    Case $0E
                                        local40 = (local40 + "198")
                                    Case $0F
                                        local40 = (local40 + "178")
                                    Case $10
                                        local40 = (local40 + "109")
                                    Case $11
                                        local40 = (local40 + "513")
                                    Case $12
                                        local40 = (local40 + "714")
                                    Case $13
                                        local40 = (local40 + "500")
                                    Case $14
                                        local40 = (local40 + "457")
                                    Case $15
                                        local40 = (local40 + "409")
                                    Case $16
                                        local40 = (local40 + "012")
                                    Case $17
                                        local40 = (local40 + "1499")
                                    Case $18
                                        local40 = (local40 + "005")
                                    Case $19
                                        local40 = (local40 + "970")
                                    Case $1A
                                        local40 = (local40 + "966")
                                    Case $1B
                                        local40 = (local40 + "447")
                                    Case $1C
                                        local40 = (local40 + "357")
                                    Case $1D
                                        local40 = (local40 + "402")
                                    Case $1E
                                        local40 = (local40 + "207")
                                    Case $1F
                                        local40 = (local40 + "1033-RU")
                                    Case $20
                                        local40 = (local40 + "035")
                                End Select
                                local41 = "paper"
                            Case ((local42 >= $28) And (local42 < $2D))
                                local45 = rand($00, $02)
                                local40 = (("Level " + (Str local45)) + " Key Card")
                                local41 = ("key" + (Str local45))
                            Case ((local42 >= $2D) And (local42 < $32))
                                local40 = "First Aid Kit"
                                local41 = "firstaid"
                            Case ((local42 >= $32) And (local42 < $3C))
                                local40 = "9V Battery"
                                local41 = "bat"
                            Case ((local42 >= $3C) And (local42 < $46))
                                local40 = "S-NAV 300 Navigator"
                                local41 = "nav"
                            Case ((local42 >= $46) And (local42 < $55))
                                local40 = "Radio Transceiver"
                                local41 = "radio"
                            Case ((local42 >= $55) And (local42 < $5F))
                                local40 = "Clipboard"
                                local41 = "clipboard"
                            Case ((local42 >= $5F) And (local42 <= $64))
                                local45 = rand($01, $03)
                                Select local45
                                    Case $01
                                        local40 = "Playing Card"
                                    Case $02
                                        local40 = "Mastercard"
                                    Case $03
                                        local40 = "Origami"
                                End Select
                                local41 = "misc"
                        End Select
                        local20 = (((864.0 * (Float local8)) + -672.0) * roomscale)
                        local47 = (((96.0 * (Float local9)) + 96.0) * roomscale)
                        local21 = (((480.0 - (352.0 * (Float local10))) + rnd(-96.0, 96.0)) * roomscale)
                        local6 = createitem(local40, local41, (arg0\Field3 + local20), local47, (arg0\Field5 + local21), $00, $00, $00, 1.0, $00)
                        entityparent(local6\Field1, arg0\Field2, $01)
                    Next
                Next
            Next
            arg0\Field21[$00] = createdoor(arg0\Field0, arg0\Field3, arg0\Field4, (arg0\Field5 - (528.0 * roomscale)), 0.0, arg0, $00, $00, $06, "", $00)
            positionentity(arg0\Field21[$00]\Field3[$00], entityx(arg0\Field21[$00]\Field3[$00], $01), entityy(arg0\Field21[$00]\Field3[$00], $01), (entityz(arg0\Field21[$00]\Field3[$00], $01) + 0.061), $01)
            positionentity(arg0\Field21[$00]\Field3[$01], entityx(arg0\Field21[$00]\Field3[$01], $01), entityy(arg0\Field21[$00]\Field3[$01], $01), (entityz(arg0\Field21[$00]\Field3[$01], $01) - 0.061), $01)
            local2 = createsecuritycam((arg0\Field3 - (256.0 * roomscale)), (arg0\Field4 + (384.0 * roomscale)), (arg0\Field5 + (640.0 * roomscale)), arg0, $00)
            local2\Field11 = 180.0
            local2\Field12 = 45.0
            turnentity(local2\Field3, 20.0, 0.0, 0.0, $00)
        Case "room1123"
            local6 = createitem("Document SCP-1123", "paper", (arg0\Field3 + (511.0 * roomscale)), (arg0\Field4 + (125.0 * roomscale)), (arg0\Field5 - (936.0 * roomscale)), $00, $00, $00, 1.0, $00)
            entityparent(local6\Field1, arg0\Field2, $01)
            local6 = createitem("SCP-1123", "scp1123", (arg0\Field3 + (832.0 * roomscale)), (arg0\Field4 + (166.0 * roomscale)), (arg0\Field5 + (784.0 * roomscale)), $00, $00, $00, 1.0, $00)
            entityparent(local6\Field1, arg0\Field2, $01)
            rotateentity(local6\Field1, 0.0, 90.0, 0.0, $00)
            local6 = createitem("Leaflet", "paper", (arg0\Field3 - (816.0 * roomscale)), (arg0\Field4 + (704.0 * roomscale)), (arg0\Field5 + (888.0 * roomscale)), $00, $00, $00, 1.0, $00)
            entityparent(local6\Field1, arg0\Field2, $01)
            local6 = createitem("Gas Mask", "gasmask", (arg0\Field3 + (457.0 * roomscale)), (arg0\Field4 + (150.0 * roomscale)), (arg0\Field5 + (960.0 * roomscale)), $00, $00, $00, 1.0, $00)
            entityparent(local6\Field1, arg0\Field2, $01)
            local0 = createdoor(arg0\Field0, (arg0\Field3 + (832.0 * roomscale)), arg0\Field4, (arg0\Field5 + (367.0 * roomscale)), 0.0, arg0, $00, $00, $05, "", $00)
            positionentity(local0\Field3[$00], (entityx(local0\Field3[$00], $01) - 0.12), entityy(local0\Field3[$00], $01), (entityz(local0\Field3[$00], $01) + 0.061), $01)
            positionentity(local0\Field3[$01], (entityx(local0\Field3[$01], $01) + 0.12), entityy(local0\Field3[$01], $01), (entityz(local0\Field3[$01], $01) - 0.061), $01)
            freeentity(local0\Field1)
            local0\Field1 = $00
            local0 = createdoor(arg0\Field0, (arg0\Field3 + (280.0 * roomscale)), arg0\Field4, (arg0\Field5 - (607.0 * roomscale)), 90.0, arg0, $00, $00, $00, "", $00)
            positionentity(local0\Field3[$00], (entityx(local0\Field3[$00], $01) - 0.031), entityy(local0\Field3[$00], $01), entityz(local0\Field3[$00], $01), $01)
            positionentity(local0\Field3[$01], (entityx(local0\Field3[$01], $01) + 0.031), entityy(local0\Field3[$01], $01), entityz(local0\Field3[$01], $01), $01)
            local0 = createdoor(arg0\Field0, (arg0\Field3 + (280.0 * roomscale)), (arg0\Field4 + (512.0 * roomscale)), (arg0\Field5 - (607.0 * roomscale)), 90.0, arg0, $00, $00, $00, "", $00)
            positionentity(local0\Field3[$00], (entityx(local0\Field3[$00], $01) - 0.031), entityy(local0\Field3[$00], $01), entityz(local0\Field3[$00], $01), $01)
            freeentity(local0\Field3[$01])
            local0\Field3[$01] = $00
            arg0\Field21[$00] = local0
            arg0\Field21[$01] = createdoor(arg0\Field0, (arg0\Field3 + (832.0 * roomscale)), (arg0\Field4 + (512.0 * roomscale)), (arg0\Field5 + (367.0 * roomscale)), 0.0, arg0, $00, $00, $05, "", $00)
            positionentity(arg0\Field21[$01]\Field3[$00], (entityx(arg0\Field21[$01]\Field3[$00], $01) - 0.12), entityy(arg0\Field21[$01]\Field3[$00], $01), (entityz(arg0\Field21[$01]\Field3[$00], $01) + 0.061), $01)
            positionentity(arg0\Field21[$01]\Field3[$01], (entityx(arg0\Field21[$01]\Field3[$01], $01) + 0.12), entityy(arg0\Field21[$01]\Field3[$01], $01), (entityz(arg0\Field21[$01]\Field3[$01], $01) - 0.061), $01)
            freeentity(arg0\Field21[$01]\Field1)
            arg0\Field21[$01]\Field1 = $00
            arg0\Field21[$01]\Field5 = $01
            arg0\Field21[$01]\Field4 = $01
            arg0\Field21[$01]\Field21 = $00
            arg0\Field19[$03] = createpivot($00)
            positionentity(arg0\Field19[$03], (arg0\Field3 + (832.0 * roomscale)), (arg0\Field4 + (166.0 * roomscale)), (arg0\Field5 + (784.0 * roomscale)), $00)
            entityparent(arg0\Field19[$03], arg0\Field2, $01)
            arg0\Field19[$04] = createpivot($00)
            positionentity(arg0\Field19[$04], (arg0\Field3 - (648.0 * roomscale)), (arg0\Field4 + (592.0 * roomscale)), (arg0\Field5 + (692.0 * roomscale)), $00)
            entityparent(arg0\Field19[$04], arg0\Field2, $01)
            arg0\Field19[$05] = createpivot($00)
            positionentity(arg0\Field19[$05], (arg0\Field3 + (828.0 * roomscale)), (arg0\Field4 + (592.0 * roomscale)), (arg0\Field5 + (592.0 * roomscale)), $00)
            entityparent(arg0\Field19[$05], arg0\Field2, $01)
            arg0\Field19[$06] = createpivot($00)
            positionentity(arg0\Field19[$06], (arg0\Field3 - (76.0 * roomscale)), (arg0\Field4 + (620.0 * roomscale)), (arg0\Field5 + (744.0 * roomscale)), $00)
            entityparent(arg0\Field19[$06], arg0\Field2, $01)
            arg0\Field19[$07] = createpivot($00)
            positionentity(arg0\Field19[$07], (arg0\Field3 - (640.0 * roomscale)), (arg0\Field4 + (620.0 * roomscale)), (arg0\Field5 - (864.0 * roomscale)), $00)
            entityparent(arg0\Field19[$07], arg0\Field2, $01)
            arg0\Field19[$08] = copyentity(local11\Field3[$08], $00)
            positionentity(arg0\Field19[$08], (arg0\Field3 - (272.0 * roomscale)), (arg0\Field4 + (512.0 * roomscale)), (arg0\Field5 + (288.0 * roomscale)), $00)
            rotateentity(arg0\Field19[$08], 0.0, 90.0, 0.0, $00)
            scaleentity(arg0\Field19[$08], (45.0 * roomscale), (45.0 * roomscale), (80.0 * roomscale), $00)
            entityparent(arg0\Field19[$08], arg0\Field2, $01)
            arg0\Field19[$09] = copyentity(local11\Field3[$09], $00)
            positionentity(arg0\Field19[$09], (arg0\Field3 - (272.0 * roomscale)), (arg0\Field4 + (512.0 * roomscale)), (arg0\Field5 + (218.0 * roomscale)), $00)
            rotateentity(arg0\Field19[$09], 0.0, 10.0, 0.0, $00)
            entitytype(arg0\Field19[$09], $01, $00)
            scaleentity(arg0\Field19[$09], (46.0 * roomscale), (45.0 * roomscale), (46.0 * roomscale), $00)
            entityparent(arg0\Field19[$09], arg0\Field2, $01)
            arg0\Field19[$0A] = copyentity(arg0\Field19[$08], $00)
            positionentity(arg0\Field19[$0A], (arg0\Field3 - (272.0 * roomscale)), (arg0\Field4 + (512.0 * roomscale)), (arg0\Field5 + (736.0 * roomscale)), $00)
            rotateentity(arg0\Field19[$0A], 0.0, 90.0, 0.0, $00)
            scaleentity(arg0\Field19[$0A], (45.0 * roomscale), (45.0 * roomscale), (80.0 * roomscale), $00)
            entityparent(arg0\Field19[$0A], arg0\Field2, $01)
            arg0\Field19[$0B] = copyentity(arg0\Field19[$09], $00)
            positionentity(arg0\Field19[$0B], (arg0\Field3 - (272.0 * roomscale)), (arg0\Field4 + (512.0 * roomscale)), (arg0\Field5 + (666.0 * roomscale)), $00)
            rotateentity(arg0\Field19[$0B], 0.0, 90.0, 0.0, $00)
            entitytype(arg0\Field19[$0B], $01, $00)
            scaleentity(arg0\Field19[$0B], (46.0 * roomscale), (45.0 * roomscale), (46.0 * roomscale), $00)
            entityparent(arg0\Field19[$0B], arg0\Field2, $01)
            arg0\Field19[$0C] = copyentity(arg0\Field19[$08], $00)
            positionentity(arg0\Field19[$0C], (arg0\Field3 - (592.0 * roomscale)), (arg0\Field4 + (512.0 * roomscale)), (arg0\Field5 - (704.0 * roomscale)), $00)
            rotateentity(arg0\Field19[$0C], 0.0, 0.0, 0.0, $00)
            scaleentity(arg0\Field19[$0C], (45.0 * roomscale), (45.0 * roomscale), (80.0 * roomscale), $00)
            entityparent(arg0\Field19[$0C], arg0\Field2, $01)
            arg0\Field19[$0D] = copyentity(arg0\Field19[$09], $00)
            positionentity(arg0\Field19[$0D], (arg0\Field3 - (662.0 * roomscale)), (arg0\Field4 + (512.0 * roomscale)), (arg0\Field5 - (704.0 * roomscale)), $00)
            rotateentity(arg0\Field19[$0D], 0.0, 0.0, 0.0, $00)
            entitytype(arg0\Field19[$0D], $01, $00)
            scaleentity(arg0\Field19[$0D], (46.0 * roomscale), (45.0 * roomscale), (46.0 * roomscale), $00)
            entityparent(arg0\Field19[$0D], arg0\Field2, $01)
            If (arg0\Field19[$0E] = $00) Then
                arg0\Field19[$0E] = loadmesh_strict(scpmodding_processfilepath("GFX\map\room1123_hb.b3d"), arg0\Field2)
            EndIf
            entitypickmode(arg0\Field19[$0E], $02, $01)
            entitytype(arg0\Field19[$0E], $01, $00)
            entityalpha(arg0\Field19[$0E], 0.0)
        Case "pocketdimension"
            local48 = loadmesh_strict(scpmodding_processfilepath("GFX\map\pocketdimension2.b3d"), $00)
            arg0\Field19[$08] = loadmesh_strict(scpmodding_processfilepath("GFX\map\pocketdimension3.b3d"), $00)
            arg0\Field19[$09] = loadmesh_strict(scpmodding_processfilepath("GFX\map\pocketdimension4.b3d"), $00)
            arg0\Field19[$0A] = copyentity(arg0\Field19[$09], $00)
            arg0\Field19[$0B] = loadmesh_strict(scpmodding_processfilepath("GFX\map\pocketdimension5.b3d"), $00)
            local49 = loadmesh_strict(scpmodding_processfilepath("GFX\map\pocketdimensionterrain.b3d"), $00)
            scaleentity(local49, roomscale, roomscale, roomscale, $01)
            positionentity(local49, arg0\Field3, (arg0\Field4 + 2944.0), arg0\Field5, $01)
            createitem("Burnt Note", "paper", entityx(arg0\Field2, $00), (arg0\Field4 + 0.5), (entityz(arg0\Field2, $00) + 3.5), $00, $00, $00, 1.0, $00)
            For local17 = $00 To $FFFFFFFF Step $01
                Select local17
                    Case $00
                        local51 = local48
                    Case $01
                        local51 = arg0\Field19[$08]
                    Case $02
                        local51 = arg0\Field19[$09]
                    Case $03
                        local51 = arg0\Field19[$0A]
                    Case $04
                        local51 = arg0\Field19[$0B]
                End Select
            Next
            For local7 = $08 To $0B Step $01
                scaleentity(arg0\Field19[local7], roomscale, roomscale, roomscale, $00)
                entitytype(arg0\Field19[local7], $01, $00)
                entitypickmode(arg0\Field19[local7], $02, $01)
                positionentity(arg0\Field19[local7], arg0\Field3, arg0\Field4, (arg0\Field5 + 32.0), $01)
            Next
            scaleentity(local49, roomscale, roomscale, roomscale, $00)
            entitytype(local49, $01, $00)
            entitypickmode(local49, $03, $01)
            positionentity(local49, arg0\Field3, (arg0\Field4 + (2944.0 * roomscale)), (arg0\Field5 + 32.0), $01)
            arg0\Field21[$00] = createdoor($00, arg0\Field3, (arg0\Field4 + (2048.0 * roomscale)), ((arg0\Field5 + 32.0) - (1024.0 * roomscale)), 0.0, arg0, $00, $00, $00, "", $00)
            arg0\Field21[$01] = createdoor($00, arg0\Field3, (arg0\Field4 + (2048.0 * roomscale)), ((arg0\Field5 + 32.0) + (1024.0 * roomscale)), 180.0, arg0, $00, $00, $00, "", $00)
            local3 = createdecal($12, (arg0\Field3 - (1536.0 * roomscale)), 0.02, ((arg0\Field5 + (608.0 * roomscale)) + 32.0), 90.0, 0.0, 0.0)
            entityparent(local3\Field0, arg0\Field2, $01)
            local3\Field2 = rnd(0.8, 0.8)
            local3\Field6 = $02
            local3\Field7 = $09
            scalesprite(local3\Field0, local3\Field2, local3\Field2)
            entityfx(local3\Field0, $09)
            entityblend(local3\Field0, $02)
            scaleentity(arg0\Field19[$0A], (roomscale * 1.5), (roomscale * 2.0), (roomscale * 1.5), $01)
            positionentity(arg0\Field19[$0B], arg0\Field3, arg0\Field4, (arg0\Field5 + 64.0), $01)
            For local7 = $01 To $08 Step $01
                arg0\Field19[(local7 - $01)] = copyentity(local48, $00)
                scaleentity(arg0\Field19[(local7 - $01)], roomscale, roomscale, roomscale, $00)
                local52 = ((Float (local7 - $01)) * 45.0)
                entitytype(arg0\Field19[(local7 - $01)], $01, $00)
                entitypickmode(arg0\Field19[(local7 - $01)], $02, $01)
                rotateentity(arg0\Field19[(local7 - $01)], 0.0, (local52 - 90.0), 0.0, $00)
                positionentity(arg0\Field19[(local7 - $01)], (arg0\Field3 + ((512.0 * roomscale) * cos(local52))), arg0\Field4, (arg0\Field5 + ((512.0 * roomscale) * sin(local52))), $00)
                entityparent(arg0\Field19[(local7 - $01)], arg0\Field2, $01)
                If (local7 < $06) Then
                    local3 = createdecal((local7 + $07), (arg0\Field3 + (((512.0 * roomscale) * cos(local52)) * 3.0)), 0.02, (arg0\Field5 + (((512.0 * roomscale) * sin(local52)) * 3.0)), 90.0, (local52 - 90.0), 0.0)
                    local3\Field2 = rnd(0.5, 0.5)
                    local3\Field6 = $02
                    local3\Field7 = $09
                    scalesprite(local3\Field0, local3\Field2, local3\Field2)
                    entityfx(local3\Field0, $09)
                    entityblend(local3\Field0, $02)
                EndIf
            Next
            For local7 = $0C To $10 Step $01
                arg0\Field19[local7] = createpivot(arg0\Field19[$0B])
                Select local7
                    Case $0C
                        positionentity(arg0\Field19[local7], arg0\Field3, (arg0\Field4 + (200.0 * roomscale)), (arg0\Field5 + 64.0), $01)
                    Case $0D
                        positionentity(arg0\Field19[local7], (arg0\Field3 + (390.0 * roomscale)), (arg0\Field4 + (200.0 * roomscale)), ((arg0\Field5 + 64.0) + (272.0 * roomscale)), $01)
                    Case $0E
                        positionentity(arg0\Field19[local7], (arg0\Field3 + (838.0 * roomscale)), (arg0\Field4 + (200.0 * roomscale)), ((arg0\Field5 + 64.0) - (551.0 * roomscale)), $01)
                    Case $0F
                        positionentity(arg0\Field19[local7], (arg0\Field3 - (139.0 * roomscale)), (arg0\Field4 + (200.0 * roomscale)), ((arg0\Field5 + 64.0) + (1201.0 * roomscale)), $01)
                    Case $10
                        positionentity(arg0\Field19[local7], (arg0\Field3 - (1238.0 * roomscale)), (arg0\Field4 - (1664.0 * roomscale)), ((arg0\Field5 + 64.0) + (381.0 * roomscale)), $01)
                End Select
            Next
            local54 = loadtexture_strict(scpmodding_processfilepath("GFX\npcs\scp_106_eyes.png"), $01)
            arg0\Field19[$11] = createsprite($00)
            scalesprite(arg0\Field19[$11], 0.03, 0.03)
            entitytexture(arg0\Field19[$11], local54, $00, $00)
            entityblend(arg0\Field19[$11], $03)
            entityfx(arg0\Field19[$11], $09)
            spriteviewmode(arg0\Field19[$11], $02)
            arg0\Field19[$12] = loadtexture_strict(scpmodding_processfilepath("GFX\npcs\pd_plane.png"), $03)
            arg0\Field19[$13] = loadtexture_strict(scpmodding_processfilepath("GFX\npcs\pd_plane_eye.png"), $03)
            arg0\Field19[$14] = createsprite($00)
            scalesprite(arg0\Field19[$14], 8.0, 8.0)
            entitytexture(arg0\Field19[$14], arg0\Field19[$12], $00, $00)
            entityorder(arg0\Field19[$14], $64)
            entityblend(arg0\Field19[$14], $02)
            entityfx(arg0\Field19[$14], $09)
            spriteviewmode(arg0\Field19[$14], $02)
            freetexture(local55)
            freeentity(local48)
        Case "room3z3"
            local2 = createsecuritycam((arg0\Field3 - (320.0 * roomscale)), (arg0\Field4 + (384.0 * roomscale)), (arg0\Field5 + (512.25 * roomscale)), arg0, $00)
            local2\Field11 = 225.0
            local2\Field12 = 45.0
            turnentity(local2\Field3, 20.0, 0.0, 0.0, $00)
        Case "room2_3","room3_3"
            local26 = createwaypoint(arg0\Field3, (arg0\Field4 + (66.0 * roomscale)), arg0\Field5, Null, arg0)
        Case "room1lifts"
            arg0\Field19[$00] = createbutton((arg0\Field3 + (96.0 * roomscale)), (arg0\Field4 + (160.0 * roomscale)), (arg0\Field5 + (71.0 * roomscale)), 0.0, 0.0, 0.0, $04)
            arg0\Field19[$01] = createbutton((arg0\Field3 - (96.0 * roomscale)), (arg0\Field4 + (160.0 * roomscale)), (arg0\Field5 + (71.0 * roomscale)), 0.0, 0.0, 0.0, $04)
            For local7 = $00 To $01 Step $01
                entityparent(arg0\Field19[local7], arg0\Field2, $01)
            Next
            local2 = createsecuritycam((arg0\Field3 + (384.0 * roomscale)), (arg0\Field4 + (384.0 * roomscale)), (arg0\Field5 - (960.0 * roomscale)), arg0, $01)
            local2\Field11 = 45.0
            local2\Field12 = 45.0
            local2\Field19 = arg0
            turnentity(local2\Field3, 20.0, 0.0, 0.0, $00)
            entityparent(local2\Field0, arg0\Field2, $01)
            local26 = createwaypoint(arg0\Field3, (arg0\Field4 + (66.0 * roomscale)), arg0\Field5, Null, arg0)
        Case "room2servers2"
            local0 = createdoor(arg0\Field0, (arg0\Field3 + (264.0 * roomscale)), arg0\Field4, (arg0\Field5 + (672.0 * roomscale)), 270.0, arg0, $00, $00, $05, "", $00)
            positionentity(local0\Field3[$00], (entityx(local0\Field3[$00], $01) - 0.031), entityy(local0\Field3[$00], $01), entityz(local0\Field3[$00], $01), $01)
            positionentity(local0\Field3[$01], (entityx(local0\Field3[$01], $01) + 0.031), entityy(local0\Field3[$01], $01), entityz(local0\Field3[$01], $01), $01)
            local0 = createdoor(arg0\Field0, (arg0\Field3 - (512.0 * roomscale)), (arg0\Field4 - (768.0 * roomscale)), (arg0\Field5 - (336.0 * roomscale)), 0.0, arg0, $00, $00, $05, "", $00)
            positionentity(local0\Field3[$00], entityx(local0\Field3[$00], $01), entityy(local0\Field3[$00], $01), (entityz(local0\Field3[$00], $01) + 0.061), $01)
            positionentity(local0\Field3[$01], entityx(local0\Field3[$01], $01), entityy(local0\Field3[$01], $01), (entityz(local0\Field3[$01], $01) - 0.061), $01)
            local0 = createdoor(arg0\Field0, (arg0\Field3 - (510.0 * roomscale)), (arg0\Field4 - (768.0 * roomscale)), (arg0\Field5 - (1037.0 * roomscale)), 0.0, arg0, $00, $00, $05, "", $00)
            local0\Field4 = $01
            local0\Field14 = $01
            freeentity(local0\Field3[$00])
            local0\Field3[$00] = $00
            positionentity(local0\Field3[$01], entityx(local0\Field3[$01], $01), entityy(local0\Field3[$01], $01), (entityz(local0\Field3[$01], $01) - 0.012), $01)
            local6 = createitem("Night Vision Goggles", "nvgoggles", (arg0\Field3 + (56.0154 * roomscale)), (arg0\Field4 - (648.0 * roomscale)), (arg0\Field5 + (749.638 * roomscale)), $00, $00, $00, 1.0, $00)
            local6\Field13 = 200.0
            rotateentity(local6\Field1, 0.0, (Float (arg0\Field6 + rand($F5, $01))), 0.0, $00)
            entityparent(local6\Field1, arg0\Field2, $01)
        Case "room2gw","room2gw_b"
            If (arg0\Field7\Field10 = "room2gw_b") Then
                arg0\Field19[$02] = createpivot($00)
                positionentity(arg0\Field19[$02], (arg0\Field3 - (156.825 * roomscale)), (arg0\Field4 - (37.3458 * roomscale)), (arg0\Field5 + (121.364 * roomscale)), $00)
                entityparent(arg0\Field19[$02], arg0\Field2, $01)
                arg0\Field19[$00] = createpivot($00)
                positionentity(arg0\Field19[$00], (arg0\Field3 + (280.0 * roomscale)), (arg0\Field4 + (345.0 * roomscale)), (arg0\Field5 - (340.0 * roomscale)), $01)
                entityparent(arg0\Field19[$00], arg0\Field2, $01)
            EndIf
            arg0\Field21[$00] = createdoor(arg0\Field0, (arg0\Field3 + (336.0 * roomscale)), arg0\Field4, (arg0\Field5 - (382.0 * roomscale)), 0.0, arg0, $00, $00, $00, "", $00)
            arg0\Field21[$00]\Field9 = $00
            arg0\Field21[$00]\Field21 = $00
            arg0\Field21[$00]\Field5 = $01
            arg0\Field21[$00]\Field4 = $01
            arg0\Field21[$00]\Field24 = $00
            freeentity(arg0\Field21[$00]\Field3[$00])
            arg0\Field21[$00]\Field3[$00] = $00
            freeentity(arg0\Field21[$00]\Field3[$01])
            arg0\Field21[$00]\Field3[$01] = $00
            arg0\Field21[$01] = createdoor(arg0\Field0, (arg0\Field3 + (336.0 * roomscale)), arg0\Field4, (arg0\Field5 + (462.0 * roomscale)), 180.0, arg0, $00, $00, $00, "", $00)
            arg0\Field21[$01]\Field9 = $00
            arg0\Field21[$01]\Field21 = $00
            arg0\Field21[$01]\Field5 = $01
            arg0\Field21[$01]\Field4 = $01
            arg0\Field21[$01]\Field24 = $00
            freeentity(arg0\Field21[$01]\Field3[$00])
            arg0\Field21[$01]\Field3[$00] = $00
            freeentity(arg0\Field21[$01]\Field3[$01])
            arg0\Field21[$01]\Field3[$01] = $00
            For local4 = Each rooms
                If (local4 <> arg0) Then
                    If (((local4\Field7\Field10 = "room2gw") Or (local4\Field7\Field10 = "room2gw_b")) <> 0) Then
                        arg0\Field19[$03] = copyentity(local4\Field19[$03], arg0\Field2)
                        Exit
                    EndIf
                EndIf
            Next
            If (arg0\Field19[$03] = $00) Then
                arg0\Field19[$03] = loadmesh_strict(scpmodding_processfilepath("GFX\map\room2gw_pipes.b3d"), arg0\Field2)
            EndIf
            entitypickmode(arg0\Field19[$03], $02, $01)
            If (arg0\Field7\Field10 = "room2gw") Then
                arg0\Field19[$00] = createpivot($00)
                positionentity(arg0\Field19[$00], (arg0\Field3 + (344.0 * roomscale)), (arg0\Field4 + (128.0 * roomscale)), arg0\Field5, $00)
                entityparent(arg0\Field19[$00], arg0\Field2, $01)
                local56 = $00
                If (room2gw_brokendoor <> 0) Then
                    If (room2gw_x = arg0\Field3) Then
                        If (room2gw_z = arg0\Field5) Then
                            local56 = $01
                        EndIf
                    EndIf
                EndIf
                If ((((room2gw_brokendoor = $00) And (rand($01, $02) = $01)) Or local56) <> 0) Then
                    arg0\Field19[$01] = copyentity(local11\Field3[$00], $00)
                    scaleentity(arg0\Field19[$01], ((204.0 * roomscale) / meshwidth(arg0\Field19[$01])), ((312.0 * roomscale) / meshheight(arg0\Field19[$01])), ((16.0 * roomscale) / meshdepth(arg0\Field19[$01])), $00)
                    entitytype(arg0\Field19[$01], $01, $00)
                    positionentity(arg0\Field19[$01], (arg0\Field3 + (336.0 * roomscale)), 0.0, (arg0\Field5 + (462.0 * roomscale)), $00)
                    rotateentity(arg0\Field19[$01], 0.0, 360.0, 0.0, $00)
                    entityparent(arg0\Field19[$01], arg0\Field2, $01)
                    moveentity(arg0\Field19[$01], 120.0, 0.0, 5.0)
                    room2gw_brokendoor = $01
                    room2gw_x = arg0\Field3
                    room2gw_z = arg0\Field5
                    freeentity(arg0\Field21[$01]\Field1)
                    arg0\Field21[$01]\Field1 = $00
                EndIf
            EndIf
        Case "room1162"
            local0 = createdoor(arg0\Field0, (arg0\Field3 + (248.0 * roomscale)), arg0\Field4, (arg0\Field5 - (736.0 * roomscale)), 90.0, arg0, $00, $00, $04, "", $00)
            positionentity(local0\Field3[$00], (entityx(local0\Field3[$00], $01) - 0.031), entityy(local0\Field3[$00], $01), entityz(local0\Field3[$00], $01), $01)
            positionentity(local0\Field3[$01], (entityx(local0\Field3[$01], $01) + 0.031), entityy(local0\Field3[$01], $01), entityz(local0\Field3[$01], $01), $01)
            arg0\Field19[$00] = createpivot($00)
            positionentity(arg0\Field19[$00], (arg0\Field3 + (1012.0 * roomscale)), (arg0\Field4 + (128.0 * roomscale)), (arg0\Field5 - (622.0 * roomscale)), $00)
            entityparent(arg0\Field19[$00], arg0\Field2, $01)
            entitypickmode(arg0\Field19[$00], $01, $01)
            local6 = createitem("Document SCP-1162", "paper", (arg0\Field3 + (863.227 * roomscale)), (arg0\Field4 + (152.0 * roomscale)), (arg0\Field5 - (953.231 * roomscale)), $00, $00, $00, 1.0, $00)
            entityparent(local6\Field1, arg0\Field2, $01)
            local2 = createsecuritycam((arg0\Field3 - (192.0 * roomscale)), (arg0\Field4 + (704.0 * roomscale)), (arg0\Field5 + (192.0 * roomscale)), arg0, $00)
            local2\Field11 = 225.0
            local2\Field12 = 45.0
            turnentity(local2\Field3, 20.0, 0.0, 0.0, $00)
        Case "room2scps2"
            arg0\Field21[$00] = createdoor(arg0\Field0, (arg0\Field3 + (288.0 * roomscale)), arg0\Field4, (arg0\Field5 + (576.0 * roomscale)), 90.0, arg0, $00, $00, $05, "", $00)
            arg0\Field21[$00]\Field4 = $01
            local0 = createdoor(arg0\Field0, (arg0\Field3 + (778.5 * roomscale)), arg0\Field4, (arg0\Field5 + (672.0 * roomscale)), 90.0, arg0, $00, $00, $06, "", $00)
            positionentity(local0\Field3[$00], (entityx(local0\Field3[$00], $01) - 0.02), entityy(local0\Field3[$00], $01), entityz(local0\Field3[$00], $01), $01)
            positionentity(local0\Field3[$01], (entityx(local0\Field3[$01], $01) + 0.02), entityy(local0\Field3[$01], $01), entityz(local0\Field3[$01], $01), $01)
            arg0\Field21[$01] = createdoor(arg0\Field0, (arg0\Field3 + (556.0 * roomscale)), arg0\Field4, (arg0\Field5 + (296.0 * roomscale)), 0.0, arg0, $00, $00, $05, "", $00)
            positionentity(arg0\Field21[$01]\Field3[$00], entityx(arg0\Field21[$01]\Field3[$00], $01), entityy(arg0\Field21[$01]\Field3[$00], $01), (entityz(arg0\Field21[$01]\Field3[$00], $01) + 0.031), $01)
            positionentity(arg0\Field21[$01]\Field3[$01], entityx(arg0\Field21[$01]\Field3[$01], $01), entityy(arg0\Field21[$01]\Field3[$01], $01), (entityz(arg0\Field21[$01]\Field3[$01], $01) - 0.031), $01)
            arg0\Field19[$00] = createpivot($00)
            positionentity(arg0\Field19[$00], (arg0\Field3 + (576.0 * roomscale)), (arg0\Field4 + (160.0 * roomscale)), (arg0\Field5 + (632.0 * roomscale)), $00)
            entityparent(arg0\Field19[$00], arg0\Field2, $01)
            local6 = createitem("SCP-1499", "scp1499", (arg0\Field3 + (600.0 * roomscale)), (arg0\Field4 + (176.0 * roomscale)), (arg0\Field5 - (228.0 * roomscale)), $00, $00, $00, 1.0, $00)
            entityparent(local6\Field1, arg0\Field2, $01)
            rotateentity(local6\Field1, 0.0, 0.0, 0.0, $00)
            local6 = createitem("SCP-500", "scp500", (arg0\Field3 + (1152.0 * roomscale)), (arg0\Field4 + (100.0 * roomscale)), (arg0\Field5 + (336.0 * roomscale)), $00, $00, $00, 1.0, $00)
            entityparent(local6\Field1, arg0\Field2, $01)
            rotateentity(local6\Field1, 0.0, 180.0, 0.0, $00)
            local6 = createitem("Document SCP-1499", "paper", (arg0\Field3 + (840.0 * roomscale)), (arg0\Field4 + (260.0 * roomscale)), (arg0\Field5 + (224.0 * roomscale)), $00, $00, $00, 1.0, $00)
            entityparent(local6\Field1, arg0\Field2, $01)
            local6 = createitem("Document SCP-500", "paper", (arg0\Field3 + (890.0 * roomscale)), (arg0\Field4 + (228.0 * roomscale)), (arg0\Field5 + (490.0 * roomscale)), $00, $00, $00, 1.0, $00)
            entityparent(local6\Field1, arg0\Field2, $01)
            rotateentity(local6\Field1, 0.0, 90.0, 0.0, $00)
            local6 = createitem("Emily Ross' Badge", "badge", (arg0\Field3 + (364.0 * roomscale)), (arg0\Field4 + (5.0 * roomscale)), (arg0\Field5 + (716.0 * roomscale)), $00, $00, $00, 1.0, $00)
            entityparent(local6\Field1, arg0\Field2, $01)
            For local7 = $00 To $01 Step $01
                Select local7
                    Case $00
                        local33 = 850.0
                        local34 = 876.0
                        local35 = 352.0
                        local36 = 220.0
                    Case $01
                        local33 = 600.0
                        local34 = 150.0
                        local35 = 512.0
                        local36 = 180.0
                End Select
                local2 = createsecuritycam((arg0\Field3 + (local33 * roomscale)), (arg0\Field4 + (local35 * roomscale)), (arg0\Field5 + (local34 * roomscale)), arg0, $00)
                local2\Field11 = local36
                local2\Field12 = 30.0
                turnentity(local2\Field3, 30.0, 0.0, 0.0, $00)
                entityparent(local2\Field0, arg0\Field2, $01)
            Next
        Case "room3offices"
            local0 = createdoor(arg0\Field0, (arg0\Field3 + (736.0 * roomscale)), arg0\Field4, (arg0\Field5 + (240.0 * roomscale)), 0.0, arg0, $00, $00, $03, "", $00)
            positionentity(local0\Field3[$00], (arg0\Field3 + (892.0 * roomscale)), entityy(local0\Field3[$00], $01), (arg0\Field5 + (226.0 * roomscale)), $01)
            positionentity(local0\Field3[$01], (arg0\Field3 + (892.0 * roomscale)), entityy(local0\Field3[$01], $01), (arg0\Field5 + (253.0 * roomscale)), $01)
            freeentity(local0\Field1)
            local0\Field1 = $00
            If (arg0\Field19[$00] = $00) Then
                arg0\Field19[$00] = loadmesh_strict(scpmodding_processfilepath("GFX\map\room3offices_hb.b3d"), arg0\Field2)
            EndIf
            entitypickmode(arg0\Field19[$00], $02, $01)
            entitytype(arg0\Field19[$00], $01, $00)
            entityalpha(arg0\Field19[$00], 0.0)
        Case "room2offices4"
            local0 = createdoor($00, (arg0\Field3 - (240.0 * roomscale)), arg0\Field4, arg0\Field5, 90.0, arg0, $00, $00, $00, "", $00)
            positionentity(local0\Field3[$00], (arg0\Field3 - (230.0 * roomscale)), entityy(local0\Field3[$00], $01), entityz(local0\Field3[$00], $01), $01)
            positionentity(local0\Field3[$01], (arg0\Field3 - (250.0 * roomscale)), entityy(local0\Field3[$01], $01), entityz(local0\Field3[$01], $01), $01)
            local0\Field5 = $00
            local0\Field21 = $00
            local6 = createitem("Sticky Note", "paper", (arg0\Field3 - (991.0 * roomscale)), (arg0\Field4 - (242.0 * roomscale)), (arg0\Field5 + (904.0 * roomscale)), $00, $00, $00, 1.0, $00)
            entityparent(local6\Field1, arg0\Field2, $01)
        Case "room2sl"
            local58 = ((roomscale * 4.5) * 0.4)
            arg0\Field27[$00] = loadanimtexture(scpmodding_processfilepath("GFX\SL_monitors_checkpoint.png"), $01, $200, $200, $00, $04)
            arg0\Field27[$01] = loadanimtexture(scpmodding_processfilepath("GFX\Sl_monitors.png"), $01, $100, $100, $00, $08)
            arg0\Field27[$02] = loadanimtexture(scpmodding_processfilepath("GFX\Sl_monitors2.png"), $01, $200, $200, $00, $03)
            For local7 = $00 To $0E Step $01
                If (local7 <> $07) Then
                    arg0\Field19[local7] = copyentity(local11\Field2[$00], $00)
                    scaleentity(arg0\Field19[local7], local58, local58, local58, $00)
                    If (((local7 <> $04) And (local7 <> $0D)) <> 0) Then
                        local59 = createsprite($00)
                        entityfx(local59, $11)
                        spriteviewmode(local59, $02)
                        scalesprite(local59, (((meshwidth(local11\Field2[$00]) * local58) * 0.95) * 0.5), (((meshheight(local11\Field2[$00]) * local58) * 0.95) * 0.5))
                        Select local7
                            Case $00
                                entitytexture(local59, arg0\Field27[$01], $00, $00)
                            Case $01
                                entitytexture(local59, arg0\Field27[$02], $01, $00)
                            Case $02
                                entitytexture(local59, arg0\Field27[$01], $02, $00)
                            Case $03
                                entitytexture(local59, arg0\Field27[$01], $01, $00)
                            Case $06
                                entitytexture(local59, arg0\Field27[$02], $02, $00)
                            Case $08
                                entitytexture(local59, arg0\Field27[$01], $04, $00)
                            Case $09
                                entitytexture(local59, arg0\Field27[$01], $05, $00)
                            Case $0A
                                entitytexture(local59, arg0\Field27[$01], $03, $00)
                            Case $0B
                                entitytexture(local59, arg0\Field27[$01], $07, $00)
                            Case $0C
                                entitytexture(local59, arg0\Field27[$02], $00, $00)
                            Default
                                entitytexture(local59, arg0\Field27[$00], $03, $00)
                        End Select
                        entityparent(local59, arg0\Field19[local7], $01)
                    ElseIf (local7 = $04) Then
                        arg0\Field19[$14] = createsprite($00)
                        entityfx(arg0\Field19[$14], $11)
                        spriteviewmode(arg0\Field19[$14], $02)
                        scalesprite(arg0\Field19[$14], (((meshwidth(local11\Field2[$00]) * local58) * 0.95) * 0.5), (((meshheight(local11\Field2[$00]) * local58) * 0.95) * 0.5))
                        entitytexture(arg0\Field19[$14], arg0\Field27[$00], $02, $00)
                        entityparent(arg0\Field19[$14], arg0\Field19[local7], $01)
                    Else
                        arg0\Field19[$15] = createsprite($00)
                        entityfx(arg0\Field19[$15], $11)
                        spriteviewmode(arg0\Field19[$15], $02)
                        scalesprite(arg0\Field19[$15], (((meshwidth(local11\Field2[$00]) * local58) * 0.95) * 0.5), (((meshheight(local11\Field2[$00]) * local58) * 0.95) * 0.5))
                        entitytexture(arg0\Field19[$15], arg0\Field27[$01], $06, $00)
                        entityparent(arg0\Field19[$15], arg0\Field19[local7], $01)
                    EndIf
                EndIf
            Next
            For local7 = $00 To $02 Step $01
                positionentity(arg0\Field19[local7], (arg0\Field3 - (207.94 * roomscale)), (arg0\Field4 + (((112.0 * (Float local7)) + 648.0) * roomscale)), (arg0\Field5 - (60.0686 * roomscale)), $00)
                rotateentity(arg0\Field19[local7], 0.0, (Float (arg0\Field6 + $69)), 0.0, $00)
                entityparent(arg0\Field19[local7], arg0\Field2, $01)
            Next
            For local7 = $03 To $05 Step $01
                positionentity(arg0\Field19[local7], (arg0\Field3 - (231.489 * roomscale)), (arg0\Field4 + (((112.0 * (Float (local7 - $03))) + 648.0) * roomscale)), (arg0\Field5 + (95.7443 * roomscale)), $00)
                rotateentity(arg0\Field19[local7], 0.0, (Float (arg0\Field6 + $5A)), 0.0, $00)
                entityparent(arg0\Field19[local7], arg0\Field2, $01)
            Next
            For local7 = $06 To $08 Step $02
                positionentity(arg0\Field19[local7], (arg0\Field3 - (231.489 * roomscale)), (arg0\Field4 + (((112.0 * (Float (local7 - $06))) + 648.0) * roomscale)), (arg0\Field5 + (255.744 * roomscale)), $00)
                rotateentity(arg0\Field19[local7], 0.0, (Float (arg0\Field6 + $5A)), 0.0, $00)
                entityparent(arg0\Field19[local7], arg0\Field2, $01)
            Next
            For local7 = $09 To $0B Step $01
                positionentity(arg0\Field19[local7], (arg0\Field3 - (231.489 * roomscale)), (arg0\Field4 + (((112.0 * (Float (local7 - $09))) + 648.0) * roomscale)), (arg0\Field5 + (415.744 * roomscale)), $00)
                rotateentity(arg0\Field19[local7], 0.0, (Float (arg0\Field6 + $5A)), 0.0, $00)
                entityparent(arg0\Field19[local7], arg0\Field2, $01)
            Next
            For local7 = $0C To $0E Step $01
                positionentity(arg0\Field19[local7], (arg0\Field3 - (208.138 * roomscale)), (arg0\Field4 + (((112.0 * (Float (local7 - $0C))) + 648.0) * roomscale)), (arg0\Field5 + (571.583 * roomscale)), $00)
                rotateentity(arg0\Field19[local7], 0.0, (Float (arg0\Field6 + $4B)), 0.0, $00)
                entityparent(arg0\Field19[local7], arg0\Field2, $01)
            Next
            arg0\Field21[$00] = createdoor(arg0\Field0, (arg0\Field3 + (480.0 * roomscale)), arg0\Field4, (arg0\Field5 - (640.0 * roomscale)), 90.0, arg0, $00, $00, $05, "", $00)
            arg0\Field21[$00]\Field21 = $00
            positionentity(arg0\Field21[$00]\Field3[$00], (arg0\Field3 + (576.0 * roomscale)), entityy(arg0\Field21[$00]\Field3[$00], $01), (arg0\Field5 - (474.0 * roomscale)), $01)
            rotateentity(arg0\Field21[$00]\Field3[$00], 0.0, 270.0, 0.0, $00)
            arg0\Field21[$01] = createdoor(arg0\Field0, (arg0\Field3 + (544.0 * roomscale)), (arg0\Field4 + (480.0 * roomscale)), (arg0\Field5 + (256.0 * roomscale)), 270.0, arg0, $00, $00, $05, "", $00)
            arg0\Field21[$01]\Field21 = $00
            freeentity(arg0\Field21[$01]\Field1)
            arg0\Field21[$01]\Field1 = $00
            local0 = createdoor(arg0\Field0, (arg0\Field3 + (1504.0 * roomscale)), (arg0\Field4 + (480.0 * roomscale)), (arg0\Field5 + (960.0 * roomscale)), 0.0, arg0, $00, $00, $00, "", $00)
            local0\Field21 = $00
            local0\Field4 = $01
            freeentity(local0\Field3[$01])
            local0\Field3[$01] = $00
            arg0\Field19[$07] = createpivot($00)
            positionentity(arg0\Field19[$07], arg0\Field3, (arg0\Field4 + (100.0 * roomscale)), (arg0\Field5 - (800.0 * roomscale)), $01)
            entityparent(arg0\Field19[$07], arg0\Field2, $01)
            arg0\Field19[$0F] = createpivot($00)
            positionentity(arg0\Field19[$0F], (arg0\Field3 + (700.0 * roomscale)), (arg0\Field4 + (700.0 * roomscale)), (arg0\Field5 + (256.0 * roomscale)), $00)
            arg0\Field19[$10] = createpivot($00)
            positionentity(arg0\Field19[$10], (arg0\Field3 - (60.0 * roomscale)), (arg0\Field4 + (700.0 * roomscale)), (arg0\Field5 + (200.0 * roomscale)), $00)
            arg0\Field19[$11] = createpivot($00)
            positionentity(arg0\Field19[$11], (arg0\Field3 - (48.0 * roomscale)), (arg0\Field4 + (540.0 * roomscale)), (arg0\Field5 + (656.0 * roomscale)), $00)
            arg0\Field19[$12] = copyentity(local11\Field5[$00], $00)
            arg0\Field19[$13] = copyentity(local11\Field5[$01], $00)
            arg0\Field20[$00] = arg0\Field19[$13]
            For local7 = $00 To $01 Step $01
                scaleentity(arg0\Field19[($12 + local7)], 0.04, 0.04, 0.04, $00)
                positionentity(arg0\Field19[($12 + local7)], (arg0\Field3 - (49.0 * roomscale)), (arg0\Field4 + (689.0 * roomscale)), (arg0\Field5 + (912.0 * roomscale)), $00)
            Next
            rotateentity(arg0\Field19[$12], 0.0, 0.0, 0.0, $00)
            rotateentity(arg0\Field19[$13], 10.0, -180.0, 0.0, $00)
            entitypickmode(arg0\Field19[$13], $01, $00)
            entityradius(arg0\Field19[$13], 0.1, 0.0)
            For local7 = $0F To $13 Step $01
                entityparent(arg0\Field19[local7], arg0\Field2, $01)
            Next
            local2 = createsecuritycam((arg0\Field3 - (159.0 * roomscale)), (arg0\Field4 + (384.0 * roomscale)), (arg0\Field5 - (929.0 * roomscale)), arg0, $01)
            local2\Field11 = 315.0
            local2\Field19 = arg0
            turnentity(local2\Field3, 20.0, 0.0, 0.0, $00)
            entityparent(local2\Field0, arg0\Field2, $01)
            positionentity(local2\Field4, (arg0\Field3 - (231.489 * roomscale)), (arg0\Field4 + (760.0 * roomscale)), (arg0\Field5 + (255.744 * roomscale)), $00)
            turnentity(local2\Field4, 0.0, 90.0, 0.0, $00)
            entityparent(local2\Field4, arg0\Field2, $01)
        Case "room2_4"
            arg0\Field19[$06] = createpivot($00)
            positionentity(arg0\Field19[$06], (arg0\Field3 + (640.0 * roomscale)), (arg0\Field4 + (8.0 * roomscale)), (arg0\Field5 - (896.0 * roomscale)), $00)
            entityparent(arg0\Field19[$06], arg0\Field2, $01)
        Case "room3z2"
            For local4 = Each rooms
                If (((local4\Field7\Field10 = arg0\Field7\Field10) And (local4 <> arg0)) <> 0) Then
                    arg0\Field19[$00] = copyentity(local4\Field19[$00], arg0\Field2)
                    Exit
                EndIf
            Next
            If (arg0\Field19[$00] = $00) Then
                arg0\Field19[$00] = loadmesh_strict(scpmodding_processfilepath("GFX\map\room3z2_hb.b3d"), arg0\Field2)
            EndIf
            entitypickmode(arg0\Field19[$00], $02, $01)
            entitytype(arg0\Field19[$00], $01, $00)
            entityalpha(arg0\Field19[$00], 0.0)
        Case "lockroom3"
            local0 = createdoor(arg0\Field0, (arg0\Field3 - (736.0 * roomscale)), arg0\Field4, (arg0\Field5 - (104.0 * roomscale)), 0.0, arg0, $01, $00, $00, "", $00)
            local0\Field10 = $15E
            local0\Field21 = $00
            local0\Field5 = $00
            local0\Field4 = $01
            entityparent(local0\Field3[$00], $00, $01)
            positionentity(local0\Field3[$00], (arg0\Field3 - (288.0 * roomscale)), (arg0\Field4 + 0.7), (arg0\Field5 - (634.0 * roomscale)), $00)
            entityparent(local0\Field3[$00], arg0\Field2, $01)
            freeentity(local0\Field3[$01])
            local0\Field3[$01] = $00
            local1 = createdoor(arg0\Field0, (arg0\Field3 + (104.0 * roomscale)), arg0\Field4, (arg0\Field5 + (736.0 * roomscale)), 270.0, arg0, $01, $00, $00, "", $00)
            local1\Field10 = $15E
            local1\Field21 = $00
            local1\Field5 = $00
            local1\Field4 = $01
            entityparent(local1\Field3[$00], $00, $01)
            positionentity(local1\Field3[$00], (arg0\Field3 + (634.0 * roomscale)), (arg0\Field4 + 0.7), (arg0\Field5 + (288.0 * roomscale)), $00)
            rotateentity(local1\Field3[$00], 0.0, 90.0, 0.0, $00)
            entityparent(local1\Field3[$00], arg0\Field2, $01)
            freeentity(local1\Field3[$01])
            local1\Field3[$01] = $00
            local0\Field22 = local1
            local1\Field22 = local0
            local58 = ((roomscale * 4.5) * 0.4)
            arg0\Field19[$00] = copyentity(local11\Field2[$00], $00)
            scaleentity(arg0\Field19[$00], local58, local58, local58, $00)
            positionentity(arg0\Field19[$00], (arg0\Field3 + (668.0 * roomscale)), (arg0\Field4 + 1.1), (arg0\Field5 - (96.0 * roomscale)), $00)
            rotateentity(arg0\Field19[$00], 0.0, 90.0, 0.0, $00)
            arg0\Field19[$01] = copyentity(local11\Field2[$00], $00)
            scaleentity(arg0\Field19[$01], local58, local58, local58, $00)
            positionentity(arg0\Field19[$01], (arg0\Field3 + (96.0 * roomscale)), (arg0\Field4 + 1.1), (arg0\Field5 - (668.0 * roomscale)), $00)
            For local7 = $00 To $01 Step $01
                entityparent(arg0\Field19[local7], arg0\Field2, $01)
            Next
        Case "medibay"
            If (arg0\Field19[$00] = $00) Then
                arg0\Field19[$00] = loadmesh_strict(scpmodding_processfilepath("GFX\map\medibay_props.b3d"), arg0\Field2)
            EndIf
            entitytype(arg0\Field19[$00], $01, $00)
            entitypickmode(arg0\Field19[$00], $02, $01)
            arg0\Field19[$01] = createpivot($00)
            positionentity(arg0\Field19[$01], (arg0\Field3 - (762.0 * roomscale)), arg0\Field4, (arg0\Field5 - (346.0 * roomscale)), $00)
            entityparent(arg0\Field19[$01], arg0\Field2, $01)
            arg0\Field19[$02] = createpivot($00)
            positionentity(arg0\Field19[$02], (entityx(arg0\Field19[$01], $01) + (126.0 * roomscale)), entityy(arg0\Field19[$01], $01), entityz(arg0\Field19[$01], $01), $00)
            entityparent(arg0\Field19[$02], arg0\Field2, $01)
            local6 = createitem("First Aid Kit", "firstaid", (arg0\Field3 - (506.0 * roomscale)), (arg0\Field4 + (192.0 * roomscale)), (arg0\Field5 - (322.0 * roomscale)), $00, $00, $00, 1.0, $00)
            entityparent(local6\Field1, arg0\Field2, $01)
            local6 = createitem("Syringe", "syringe", (arg0\Field3 - (333.0 * roomscale)), (arg0\Field4 + (100.0 * roomscale)), (arg0\Field5 + (97.3 * roomscale)), $00, $00, $00, 1.0, $00)
            entityparent(local6\Field1, arg0\Field2, $01)
            local6 = createitem("Syringe", "syringeinf", (arg0\Field3 - (340.0 * roomscale)), (arg0\Field4 + (100.0 * roomscale)), (arg0\Field5 + (52.3 * roomscale)), $00, $00, $00, 1.0, $00)
            entityparent(local6\Field1, arg0\Field2, $01)
            local0 = createdoor(arg0\Field0, (arg0\Field3 - (264.0 * roomscale)), arg0\Field4, (arg0\Field5 + (640.0 * roomscale)), 90.0, arg0, $00, $00, $05, "", $00)
            local0\Field21 = $00
            positionentity(local0\Field3[$00], (entityx(local0\Field3[$00], $01) - 0.031), entityy(local0\Field3[$00], $01), entityz(local0\Field3[$00], $01), $01)
            positionentity(local0\Field3[$01], (entityx(local0\Field3[$01], $01) + 0.031), entityy(local0\Field3[$01], $01), entityz(local0\Field3[$01], $01), $01)
            arg0\Field19[$03] = createpivot($00)
            positionentity(arg0\Field19[$03], (arg0\Field3 - (820.0 * roomscale)), arg0\Field4, (arg0\Field5 - (318.399 * roomscale)), $00)
            entityparent(arg0\Field19[$03], arg0\Field2, $01)
            If (arg0\Field19[$04] = $00) Then
                arg0\Field19[$04] = copyentity(local11\Field0[$1E], $00)
            EndIf
            local23 = loadtexture_strict(scpmodding_processfilepath("GFX\npcs\duck(4).png"), $01)
            entitytexture(arg0\Field19[$04], local23, $00, $00)
            freetexture(local23)
            scaleentity(arg0\Field19[$04], 0.07, 0.07, 0.07, $00)
            positionentity(arg0\Field19[$04], (arg0\Field3 - (910.0 * roomscale)), (arg0\Field4 + (144.0 * roomscale)), (arg0\Field5 - (778.0 * roomscale)), $01)
            turnentity(arg0\Field19[$04], 6.0, 180.0, 0.0, $00)
            entityparent(arg0\Field19[$04], arg0\Field2, $01)
        Case "room2cpit"
            local15 = createemitter((arg0\Field3 + (512.0 * roomscale)), (arg0\Field4 - (76.0 * roomscale)), (arg0\Field5 - (688.0 * roomscale)), $00)
            turnentity(local15\Field0, -90.0, 0.0, 0.0, $00)
            entityparent(local15\Field0, arg0\Field2, $01)
            local15\Field10 = 55.0
            local15\Field9 = 0.0005
            local15\Field12 = -0.015
            local15\Field11 = 0.007
            local0 = createdoor(arg0\Field0, (arg0\Field3 - (256.0 * roomscale)), arg0\Field4, (arg0\Field5 - (752.0 * roomscale)), 90.0, arg0, $00, $02, $05, "", $00)
            local0\Field4 = $01
            local0\Field5 = $00
            local0\Field21 = $00
            local0\Field24 = $00
            local0\Field14 = $01
            positionentity(local0\Field3[$00], (entityx(local0\Field3[$00], $01) - 0.061), entityy(local0\Field3[$00], $01), entityz(local0\Field3[$00], $01), $01)
            freeentity(local0\Field3[$01])
            local0\Field3[$01] = $00
            local6 = createitem("Dr L's Note", "paper", (arg0\Field3 - (160.0 * roomscale)), (32.0 * roomscale), (arg0\Field5 - (353.0 * roomscale)), $00, $00, $00, 1.0, $00)
            entityparent(local6\Field1, arg0\Field2, $01)
        Case "dimension1499"
            arg0\Field20[$00] = createpivot($00)
            positionentity(arg0\Field20[$00], (arg0\Field3 + (205.0 * roomscale)), (arg0\Field4 + (200.0 * roomscale)), (arg0\Field5 + (2287.0 * roomscale)), $00)
            arg0\Field20[$01] = loadmesh_strict(scpmodding_processfilepath("GFX\map\dimension1499\1499object0_cull.b3d"), $00)
            entitytype(arg0\Field20[$01], $01, $00)
            entityalpha(arg0\Field20[$01], 0.0)
            For local7 = $00 To $01 Step $01
                entityparent(arg0\Field20[local7], arg0\Field2, $01)
            Next
        Case "room2posters"
            local0 = createdoor(arg0\Field0, (arg0\Field3 + (272.0 * roomscale)), arg0\Field4, (arg0\Field5 + (576.0 * roomscale)), 90.0, arg0, $00, $00, $02, "", $00)
            local0\Field21 = $00
            positionentity(local0\Field3[$00], (entityx(local0\Field3[$00], $01) + 0.061), entityy(local0\Field3[$00], $01), entityz(local0\Field3[$00], $01), $01)
            positionentity(local0\Field3[$01], (entityx(local0\Field3[$01], $01) - 0.061), entityy(local0\Field3[$01], $01), entityz(local0\Field3[$01], $01), $01)
            local6 = createitem("Ballistic Helmet", "helmet", (arg0\Field3 + (980.0 * roomscale)), (arg0\Field4 + (250.0 * roomscale)), (arg0\Field5 + (300.0 * roomscale)), $00, $00, $00, 1.0, $00)
            entityparent(local6\Field1, arg0\Field2, $01)
            local6 = createitem("Level 1 Key Card", "key1", (arg0\Field3 + (468.0 * roomscale)), (arg0\Field4 + (160.0 * roomscale)), (arg0\Field5 + (980.0 * roomscale)), $00, $00, $00, 1.0, $00)
            entityparent(local6\Field1, arg0\Field2, $01)
            local6 = createitem("Origami", "misc", (arg0\Field3 + (460.0 * roomscale)), (arg0\Field4 + (250.0 * roomscale)), (arg0\Field5 + (80.0 * roomscale)), $00, $00, $00, 1.0, $00)
            entityparent(local6\Field1, arg0\Field2, $01)
            rotateentity(local6\Field1, 0.0, 0.0, 0.0, $00)
            local6 = createitem("9V Battery", "bat", (arg0\Field3 + (900.0 * roomscale)), (arg0\Field4 + (250.0 * roomscale)), (arg0\Field5 + (80.0 * roomscale)), $00, $00, $00, 1.0, $00)
            entityparent(local6\Field1, arg0\Field2, $01)
            local2 = createsecuritycam((arg0\Field3 + (980.0 * roomscale)), (arg0\Field4 + (515.0 * roomscale)), (arg0\Field5 + (100.0 * roomscale)), arg0, $01)
            local2\Field11 = 30.0
            local2\Field12 = 30.0
            turnentity(local2\Field3, 20.0, 0.0, 0.0, $00)
            entityparent(local2\Field0, arg0\Field2, $01)
        Case "medibay2"
            If (arg0\Field19[$00] = $00) Then
                arg0\Field19[$00] = loadmesh_strict(scpmodding_processfilepath("GFX\map\medibay_props.b3d"), arg0\Field2)
            EndIf
            entitytype(arg0\Field19[$00], $01, $00)
            entitypickmode(arg0\Field19[$00], $02, $01)
            local0 = createdoor(arg0\Field0, (arg0\Field3 - (264.0 * roomscale)), arg0\Field4, (arg0\Field5 + (640.0 * roomscale)), 90.0, arg0, $00, $00, $05, "", $00)
            local0\Field21 = $00
            positionentity(local0\Field3[$00], (entityx(local0\Field3[$00], $01) - 0.031), entityy(local0\Field3[$00], $01), entityz(local0\Field3[$00], $01), $01)
            positionentity(local0\Field3[$01], (entityx(local0\Field3[$01], $01) + 0.031), entityy(local0\Field3[$01], $01), entityz(local0\Field3[$01], $01), $01)
            arg0\Field19[$04] = createpivot($00)
            positionentity(arg0\Field19[$04], (arg0\Field3 - (762.0 * roomscale)), arg0\Field4, (arg0\Field5 - (346.0 * roomscale)), $00)
            entityparent(arg0\Field19[$04], arg0\Field2, $01)
            arg0\Field19[$05] = createpivot($00)
            positionentity(arg0\Field19[$05], (entityx(arg0\Field19[$04], $01) + (126.0 * roomscale)), entityy(arg0\Field19[$04], $01), entityz(arg0\Field19[$04], $01), $00)
            entityparent(arg0\Field19[$05], arg0\Field2, $01)
            local6 = createitem("Syringe", "syringe", (arg0\Field3 - (333.0 * roomscale)), (arg0\Field4 + (100.0 * roomscale)), (arg0\Field5 + (97.3 * roomscale)), $00, $00, $00, 1.0, $00)
            entityparent(local6\Field1, arg0\Field2, $01)
            local6 = createitem("Syringe", "syringeinf", (arg0\Field3 - (340.0 * roomscale)), (arg0\Field4 + (100.0 * roomscale)), (arg0\Field5 + (52.3 * roomscale)), $00, $00, $00, 1.0, $00)
            entityparent(local6\Field1, arg0\Field2, $01)
            local6 = createitem("First Aid Kit", "firstaid", (arg0\Field3 - (506.0 * roomscale)), (arg0\Field4 + (192.0 * roomscale)), (arg0\Field5 - (322.0 * roomscale)), $00, $00, $00, 1.0, $00)
            entityparent(local6\Field1, arg0\Field2, $01)
            rotateentity(local6\Field1, 0.0, 0.0, 0.0, $00)
        Case "room1office"
            local0 = createdoor(arg0\Field0, arg0\Field3, arg0\Field4, (arg0\Field5 - (240.0 * roomscale)), 0.0, arg0, $00, $00, $00, "2411", $00)
            local0\Field21 = $00
            local6 = createitem("Field Agent Log #235-001-CO5", "paper", arg0\Field3, (arg0\Field4 + (200.0 * roomscale)), (arg0\Field5 + (870.0 * roomscale)), $00, $00, $00, 1.0, $00)
            entityparent(local6\Field1, arg0\Field2, $01)
            local6 = createitem("Groups of Interest Log", "paper", (arg0\Field3 + (100.0 * roomscale)), (arg0\Field4 + (200.0 * roomscale)), (arg0\Field5 + (100.0 * roomscale)), $00, $00, $00, 1.0, $00)
            entityparent(local6\Field1, arg0\Field2, $01)
            local6 = createitem("First Aid Kit", "firstaid", (arg0\Field3 + (680.0 * roomscale)), (arg0\Field4 + (260.0 * roomscale)), (arg0\Field5 + (885.0 * roomscale)), $00, $00, $00, 1.0, $00)
            entityparent(local6\Field1, arg0\Field2, $01)
            rotateentity(local6\Field1, 0.0, 90.0, 0.0, $00)
            local6 = createitem("9V Battery", "bat", (arg0\Field3 - (700.0 * roomscale)), (arg0\Field4 + (210.0 * roomscale)), (arg0\Field5 + (920.0 * roomscale)), $00, $00, $00, 1.0, $00)
            entityparent(local6\Field1, arg0\Field2, $01)
        Case "room650"
            local0 = createdoor(arg0\Field0, (arg0\Field3 - (608.0 * roomscale)), arg0\Field4, arg0\Field5, 90.0, arg0, $00, $00, $05, "", $00)
            local0\Field21 = $00
            local0 = createdoor(arg0\Field0, (arg0\Field3 - (416.0 * roomscale)), arg0\Field4, (arg0\Field5 + (608.0 * roomscale)), 270.0, arg0, $00, $00, $05, "", $00)
            local0\Field21 = $00
            positionentity(local0\Field3[$00], entityx(local0\Field3[$00], $01), entityy(local0\Field3[$00], $01), (entityz(local0\Field3[$00], $01) + 0.1), $01)
            positionentity(local0\Field3[$01], entityx(local0\Field3[$01], $01), entityy(local0\Field3[$01], $01), (entityz(local0\Field3[$01], $01) - 0.1), $01)
            freeentity(local0\Field1)
            local0\Field1 = $00
            local6 = createitem("Document SCP-650", "paper", (arg0\Field3 - (925.0 * roomscale)), (arg0\Field4 + (200.0 * roomscale)), (arg0\Field5 + (566.0 * roomscale)), $00, $00, $00, 1.0, $00)
            entityparent(local6\Field1, arg0\Field2, $01)
            rotateentity(local6\Field1, 0.0, 0.0, 0.0, $00)
            local6 = createitem("Unknown Note", "paper", (arg0\Field3 - (710.0 * roomscale)), (arg0\Field4 + (250.0 * roomscale)), (arg0\Field5 + (956.0 * roomscale)), $00, $00, $00, 1.0, $00)
            entityparent(local6\Field1, arg0\Field2, $01)
            rotateentity(local6\Field1, 0.0, 90.0, 0.0, $00)
            local6 = createitem("9V Battery", "bat", (arg0\Field3 - (810.0 * roomscale)), (arg0\Field4 + (150.0 * roomscale)), (arg0\Field5 - (220.0 * roomscale)), $00, $00, $00, 1.0, $00)
            entityparent(local6\Field1, arg0\Field2, $01)
            arg0\Field19[$00] = createpivot($00)
            positionentity(arg0\Field19[$00], (arg0\Field3 + (130.0 * roomscale)), arg0\Field4, (arg0\Field5 + (940.0 * roomscale)), $00)
            entityparent(arg0\Field19[$00], arg0\Field2, $01)
            local2 = createsecuritycam((arg0\Field3 + (130.0 * roomscale)), (arg0\Field4 + (577.0 * roomscale)), (arg0\Field5 + (626.0 * roomscale)), arg0, $01)
            local2\Field11 = 45.0
            local2\Field12 = 40.0
            turnentity(local2\Field3, 40.0, -60.0, 0.0, $00)
            entityparent(local2\Field0, arg0\Field2, $01)
        Case "room457"
            arg0\Field21[$07] = createdoor(arg0\Field0, arg0\Field3, (arg0\Field4 - (3072.0 * roomscale)), arg0\Field5, 0.0, arg0, $00, $02, $00, "ABCD", $00)
            arg0\Field21[$07]\Field21 = $00
            arg0\Field21[$07]\Field4 = $01
            arg0\Field21[$04] = createdoor(arg0\Field0, (arg0\Field3 + (8480.0 * roomscale)), (arg0\Field4 - (3072.0 * roomscale)), (arg0\Field5 + (1536.0 * roomscale)), 90.0, arg0, $01, $00, $00, "", $00)
            arg0\Field21[$04]\Field21 = $00
            freeentity(arg0\Field21[$04]\Field3[$00])
            arg0\Field21[$04]\Field3[$00] = $00
            freeentity(arg0\Field21[$04]\Field3[$01])
            arg0\Field21[$04]\Field3[$01] = $00
            arg0\Field21[$05] = createdoor(arg0\Field0, (arg0\Field3 + (9216.0 * roomscale)), (arg0\Field4 - (3072.0 * roomscale)), (arg0\Field5 + (1248.0 * roomscale)), 0.0, arg0, $01, $00, $00, "", $00)
            arg0\Field21[$05]\Field21 = $00
            freeentity(arg0\Field21[$05]\Field3[$00])
            arg0\Field21[$05]\Field3[$00] = $00
            freeentity(arg0\Field21[$05]\Field3[$01])
            arg0\Field21[$05]\Field3[$01] = $00
            arg0\Field21[$06] = createdoor(arg0\Field0, (arg0\Field3 + (8960.0 * roomscale)), (arg0\Field4 - (3072.0 * roomscale)), (arg0\Field5 + (1536.0 * roomscale)), 90.0, arg0, $01, $00, $00, "", $00)
            arg0\Field21[$06]\Field21 = $00
            freeentity(arg0\Field21[$06]\Field3[$00])
            arg0\Field21[$06]\Field3[$00] = $00
            freeentity(arg0\Field21[$06]\Field3[$01])
            arg0\Field21[$06]\Field3[$01] = $00
            local0 = createdoor(arg0\Field0, (arg0\Field3 + (8064.0 * roomscale)), (arg0\Field4 - (3072.0 * roomscale)), (arg0\Field5 + (1248.0 * roomscale)), 0.0, arg0, $00, $00, $05, "", $00)
            local0\Field21 = $00
            local0 = createdoor(arg0\Field0, arg0\Field3, arg0\Field4, arg0\Field5, 0.0, arg0, $00, $02, $FFFFFFFF, "", $00)
            local0\Field21 = $00
            arg0\Field21[$00] = createdoor(arg0\Field0, (arg0\Field3 - (264.0 * roomscale)), arg0\Field4, (arg0\Field5 - (656.0 * roomscale)), 90.0, arg0, $01, $03, $00, "", $00)
            arg0\Field21[$00]\Field21 = $00
            positionentity(arg0\Field21[$00]\Field3[$00], (entityx(arg0\Field21[$00]\Field3[$00], $01) + 0.031), entityy(arg0\Field21[$00]\Field3[$00], $01), entityz(arg0\Field21[$00]\Field3[$00], $01), $01)
            positionentity(arg0\Field21[$00]\Field3[$01], (entityx(arg0\Field21[$00]\Field3[$01], $01) - 0.031), entityy(arg0\Field21[$00]\Field3[$01], $01), entityz(arg0\Field21[$00]\Field3[$01], $01), $01)
            arg0\Field21[$01] = createdoor(arg0\Field0, (arg0\Field3 + (264.0 * roomscale)), arg0\Field4, (arg0\Field5 + (656.0 * roomscale)), 90.0, arg0, $01, $03, $00, "", $00)
            arg0\Field21[$01]\Field21 = $00
            positionentity(arg0\Field21[$01]\Field3[$00], (entityx(arg0\Field21[$01]\Field3[$00], $01) + 0.031), entityy(arg0\Field21[$01]\Field3[$00], $01), entityz(arg0\Field21[$01]\Field3[$00], $01), $01)
            positionentity(arg0\Field21[$01]\Field3[$01], (entityx(arg0\Field21[$01]\Field3[$01], $01) - 0.031), entityy(arg0\Field21[$01]\Field3[$01], $01), entityz(arg0\Field21[$01]\Field3[$01], $01), $01)
            arg0\Field21[$02] = createdoor(arg0\Field0, (arg0\Field3 - (264.0 * roomscale)), (arg0\Field4 - (3072.0 * roomscale)), (arg0\Field5 - (656.0 * roomscale)), 90.0, arg0, $00, $03, $00, "", $00)
            arg0\Field21[$02]\Field21 = $00
            positionentity(arg0\Field21[$02]\Field3[$00], (entityx(arg0\Field21[$02]\Field3[$00], $01) + 0.031), entityy(arg0\Field21[$02]\Field3[$00], $01), entityz(arg0\Field21[$02]\Field3[$00], $01), $01)
            positionentity(arg0\Field21[$02]\Field3[$01], (entityx(arg0\Field21[$02]\Field3[$01], $01) - 0.031), entityy(arg0\Field21[$02]\Field3[$01], $01), entityz(arg0\Field21[$02]\Field3[$01], $01), $01)
            arg0\Field21[$03] = createdoor(arg0\Field0, (arg0\Field3 + (264.0 * roomscale)), (arg0\Field4 - (3072.0 * roomscale)), (arg0\Field5 + (656.0 * roomscale)), 90.0, arg0, $00, $03, $00, "", $00)
            arg0\Field21[$03]\Field21 = $00
            positionentity(arg0\Field21[$03]\Field3[$00], (entityx(arg0\Field21[$03]\Field3[$00], $01) + 0.031), entityy(arg0\Field21[$03]\Field3[$00], $01), entityz(arg0\Field21[$03]\Field3[$00], $01), $01)
            positionentity(arg0\Field21[$03]\Field3[$01], (entityx(arg0\Field21[$03]\Field3[$01], $01) - 0.031), entityy(arg0\Field21[$03]\Field3[$01], $01), entityz(arg0\Field21[$03]\Field3[$01], $01), $01)
            local0 = createdoor(arg0\Field0, (arg0\Field3 - (1056.0 * roomscale)), (arg0\Field4 - (3072.0 * roomscale)), (arg0\Field5 + (1792.0 * roomscale)), 90.0, arg0, $01, $03, $00, "", $00)
            local0\Field21 = $00
            local0\Field4 = $01
            local0\Field14 = $01
            local0 = createdoor(arg0\Field0, (arg0\Field3 + (2832.0 * roomscale)), (arg0\Field4 - (3072.0 * roomscale)), (arg0\Field5 + (1792.0 * roomscale)), 90.0, arg0, $00, $03, $00, "", $00)
            local0\Field21 = $00
            local0\Field4 = $01
            local0\Field14 = $01
            freeentity(local0\Field3[$00])
            local0\Field3[$00] = $00
            positionentity(local0\Field3[$01], (entityx(local0\Field3[$01], $01) + 0.061), entityy(local0\Field3[$01], $01), entityz(local0\Field3[$01], $01), $01)
            local0 = createdoor(arg0\Field0, (arg0\Field3 + (2832.0 * roomscale)), (arg0\Field4 - (3072.0 * roomscale)), (arg0\Field5 + (2368.0 * roomscale)), 90.0, arg0, $00, $03, $00, "", $00)
            local0\Field21 = $00
            local0\Field4 = $01
            local0\Field14 = $01
            freeentity(local0\Field3[$00])
            local0\Field3[$00] = $00
            positionentity(local0\Field3[$01], (entityx(local0\Field3[$01], $01) + 0.061), entityy(local0\Field3[$01], $01), entityz(local0\Field3[$01], $01), $01)
            arg0\Field19[$00] = createpivot($00)
            positionentity(arg0\Field19[$00], arg0\Field3, (arg0\Field4 - (2994.0 * roomscale)), (arg0\Field5 + (3072.0 * roomscale)), $00)
            entityparent(arg0\Field19[$00], arg0\Field2, $01)
            arg0\Field19[$01] = createpivot($00)
            positionentity(arg0\Field19[$01], (arg0\Field3 + (1024.0 * roomscale)), (arg0\Field4 - (2994.0 * roomscale)), (arg0\Field5 - (192.0 * roomscale)), $00)
            entityparent(arg0\Field19[$01], arg0\Field2, $01)
            arg0\Field19[$02] = createpivot($00)
            positionentity(arg0\Field19[$02], (arg0\Field3 + (5952.0 * roomscale)), (arg0\Field4 - (2994.0 * roomscale)), (arg0\Field5 - (256.0 * roomscale)), $00)
            entityparent(arg0\Field19[$02], arg0\Field2, $01)
            arg0\Field19[$03] = createpivot($00)
            positionentity(arg0\Field19[$03], (arg0\Field3 + (4768.0 * roomscale)), (arg0\Field4 - (2994.0 * roomscale)), (arg0\Field5 + (3072.0 * roomscale)), $00)
            entityparent(arg0\Field19[$03], arg0\Field2, $01)
            arg0\Field19[$04] = createpivot($00)
            positionentity(arg0\Field19[$04], (arg0\Field3 + (8868.0 * roomscale)), (arg0\Field4 - (2994.0 * roomscale)), (arg0\Field5 + (764.0 * roomscale)), $00)
            entityparent(arg0\Field19[$04], arg0\Field2, $01)
            arg0\Field19[$05] = createpivot($00)
            positionentity(arg0\Field19[$05], (arg0\Field3 - (560.0 * roomscale)), (arg0\Field4 + (240.0 * roomscale)), (arg0\Field5 - (656.0 * roomscale)), $00)
            entityparent(arg0\Field19[$05], arg0\Field2, $01)
            arg0\Field19[$06] = createpivot($00)
            positionentity(arg0\Field19[$06], (arg0\Field3 + (560.0 * roomscale)), (arg0\Field4 + (240.0 * roomscale)), (arg0\Field5 + (656.0 * roomscale)), $00)
            entityparent(arg0\Field19[$06], arg0\Field2, $01)
            arg0\Field19[$07] = createpivot($00)
            positionentity(arg0\Field19[$07], (arg0\Field3 - (560.0 * roomscale)), (arg0\Field4 - (2834.0 * roomscale)), (arg0\Field5 - (656.0 * roomscale)), $00)
            entityparent(arg0\Field19[$07], arg0\Field2, $01)
            arg0\Field19[$08] = createpivot($00)
            positionentity(arg0\Field19[$08], (arg0\Field3 + (560.0 * roomscale)), (arg0\Field4 - (2834.0 * roomscale)), (arg0\Field5 + (656.0 * roomscale)), $00)
            entityparent(arg0\Field19[$08], arg0\Field2, $01)
            local6 = createitem("Document SCP-457", "paper", (arg0\Field3 + (1728.0 * roomscale)), (arg0\Field4 - (2682.0 * roomscale)), (arg0\Field5 - (128.0 * roomscale)), $00, $00, $00, 1.0, $00)
            entityparent(local6\Field1, arg0\Field2, $01)
            local6 = createitem("SCP-457 Addendum", "paper", (arg0\Field3 + (8240.0 * roomscale)), (arg0\Field4 - (3005.0 * roomscale)), (arg0\Field5 + (650.0 * roomscale)), $00, $00, $00, 1.0, $00)
            entityparent(local6\Field1, arg0\Field2, $01)
            local6 = createitem("9V Battery", "bat", (arg0\Field3 + (1070.0 * roomscale)), (arg0\Field4 - (2886.0 * roomscale)), (arg0\Field5 + (258.0 * roomscale)), $00, $00, $00, 1.0, $00)
            entityparent(local6\Field1, arg0\Field2, $01)
            local2 = createsecuritycam((arg0\Field3 + (9488.0 * roomscale)), (arg0\Field4 - (2566.0 * roomscale)), (arg0\Field5 + (340.0 * roomscale)), arg0, $01)
            local2\Field11 = 45.0
            local2\Field12 = 45.0
            turnentity(local2\Field3, 20.0, 0.0, 0.0, $00)
            entityparent(local2\Field0, arg0\Field2, $01)
            arg0\Field19[$09] = copyentity(local11\Field5[$01], $00)
            arg0\Field20[$00] = arg0\Field19[$09]
            scaleentity(arg0\Field20[$00], 0.04, 0.04, 0.04, $00)
            positionentity(arg0\Field20[$00], (arg0\Field3 + (8024.0 * roomscale)), (arg0\Field4 - (2864.0 * roomscale)), (arg0\Field5 + (330.0 * roomscale)), $00)
            entityparent(arg0\Field20[$00], arg0\Field2, $01)
            rotateentity(arg0\Field20[$00], -75.0, -360.0, 0.0, $00)
            entitypickmode(arg0\Field20[$00], $01, $00)
            entityradius(arg0\Field20[$00], 0.1, 0.0)
            arg0\Field19[$0A] = copyentity(local11\Field5[$01], $00)
            scaleentity(arg0\Field19[$0A], 0.04, 0.04, 0.04, $00)
            positionentity(arg0\Field19[$0A], (arg0\Field3 + (8132.0 * roomscale)), (arg0\Field4 - (3069.0 * roomscale)), (arg0\Field5 + (396.0 * roomscale)), $00)
            entityparent(arg0\Field19[$0A], arg0\Field2, $01)
            rotateentity(arg0\Field19[$0A], 0.0, (Float rand($168, $01)), 0.0, $00)
            entitypickmode(arg0\Field19[$0A], $01, $00)
            entityradius(arg0\Field19[$0A], 0.1, 0.0)
        Case "room4info"
            arg0\Field19[$00] = createpivot($00)
            positionentity(arg0\Field19[$00], (arg0\Field3 + (492.0 * roomscale)), (arg0\Field4 + (258.0 * roomscale)), (arg0\Field5 - (810.0 * roomscale)), $00)
            entityparent(arg0\Field19[$00], arg0\Field2, $01)
            local6 = createitem("Radio Transceiver", "fineradio", (arg0\Field3 + (650.0 * roomscale)), (arg0\Field4 + (258.0 * roomscale)), (arg0\Field5 - (760.0 * roomscale)), $00, $00, $00, 1.0, $00)
            entityparent(local6\Field1, arg0\Field2, $01)
            arg0\Field19[$01] = copyentity(local11\Field2[$01], arg0\Field2)
            scaleentity(arg0\Field19[$01], 2.0, 2.0, 2.0, $00)
            positionentity(arg0\Field19[$01], (arg0\Field3 - (700.0 * roomscale)), (arg0\Field4 + (384.0 * roomscale)), (arg0\Field5 + (290.0 * roomscale)), $01)
            rotateentity(arg0\Field19[$01], 0.0, 360.0, 0.0, $00)
            entityfx(arg0\Field19[$01], $01)
            arg0\Field19[$02] = createpivot($00)
            positionentity(arg0\Field19[$02], (arg0\Field3 + (650.0 * roomscale)), (arg0\Field4 + (258.0 * roomscale)), (arg0\Field5 - (760.0 * roomscale)), $00)
            entityparent(arg0\Field19[$02], arg0\Field2, $01)
        Case "room009"
            arg0\Field21[$00] = createdoor(arg0\Field0, arg0\Field3, arg0\Field4, (arg0\Field5 - (640.0 * roomscale)), 0.0, arg0, $00, $02, $05, "", $00)
            arg0\Field21[$00]\Field21 = $00
            arg0\Field21[$01] = createdoor(arg0\Field0, (arg0\Field3 + (640.0 * roomscale)), arg0\Field4, arg0\Field5, 90.0, arg0, $01, $02, $05, "", $00)
            arg0\Field21[$01]\Field21 = $00
            arg0\Field21[$01]\Field4 = $01
            arg0\Field21[$01]\Field24 = $00
            arg0\Field21[$01]\Field14 = $01
            arg0\Field21[$02] = createdoor(arg0\Field0, (arg0\Field3 - (640.0 * roomscale)), arg0\Field4, arg0\Field5, 90.0, arg0, $00, $02, $05, "", $00)
            arg0\Field21[$02]\Field21 = $00
            arg0\Field21[$03] = createdoor(arg0\Field0, (arg0\Field3 - (831.0 * roomscale)), arg0\Field4, (arg0\Field5 + (352.0 * roomscale)), 0.0, arg0, $01, $00, $05, "", $00)
            arg0\Field21[$03]\Field21 = $00
            arg0\Field21[$03]\Field4 = $01
            arg0\Field21[$03]\Field24 = $00
            positionentity(arg0\Field21[$03]\Field3[$00], (entityx(arg0\Field21[$03]\Field3[$00], $01) - 0.1), entityy(arg0\Field21[$03]\Field3[$00], $01), entityz(arg0\Field21[$03]\Field3[$00], $01), $01)
            positionentity(arg0\Field21[$03]\Field3[$01], (entityx(arg0\Field21[$03]\Field3[$01], $01) + 0.1), entityy(arg0\Field21[$03]\Field3[$01], $01), entityz(arg0\Field21[$03]\Field3[$01], $01), $01)
            freeentity(arg0\Field21[$03]\Field1)
            arg0\Field21[$03]\Field1 = $00
            arg0\Field21[$04] = createdoor(arg0\Field0, (arg0\Field3 + (831.0 * roomscale)), arg0\Field4, (arg0\Field5 + (352.0 * roomscale)), 180.0, arg0, $00, $00, $05, "", $00)
            arg0\Field21[$04]\Field21 = $00
            positionentity(arg0\Field21[$04]\Field3[$00], (entityx(arg0\Field21[$04]\Field3[$00], $01) + 0.1), entityy(arg0\Field21[$04]\Field3[$00], $01), entityz(arg0\Field21[$04]\Field3[$00], $01), $01)
            positionentity(arg0\Field21[$04]\Field3[$01], (entityx(arg0\Field21[$04]\Field3[$01], $01) - 0.1), entityy(arg0\Field21[$04]\Field3[$01], $01), entityz(arg0\Field21[$04]\Field3[$01], $01), $01)
            freeentity(arg0\Field21[$04]\Field1)
            arg0\Field21[$04]\Field1 = $00
            local0 = createdoor(arg0\Field0, (arg0\Field3 + (655.0 * roomscale)), arg0\Field4, (arg0\Field5 - (655.0 * roomscale)), 135.0, arg0, $00, $02, $FFFFFFFD, "", $00)
            local0\Field21 = $00
            local0 = createdoor(arg0\Field0, (arg0\Field3 - (831.0 * roomscale)), arg0\Field4, (arg0\Field5 - (352.0 * roomscale)), 0.0, arg0, $00, $02, $00, "", $00)
            local0\Field21 = $00
            local0\Field4 = $01
            positionentity(local0\Field3[$00], (entityx(local0\Field3[$00], $01) - 0.1), entityy(local0\Field3[$00], $01), entityz(local0\Field3[$00], $01), $01)
            positionentity(local0\Field3[$01], (entityx(local0\Field3[$01], $01) + 0.1), entityy(local0\Field3[$01], $01), entityz(local0\Field3[$01], $01), $01)
            local0 = createdoor(arg0\Field0, (arg0\Field3 - (352.0 * roomscale)), arg0\Field4, (arg0\Field5 - (831.0 * roomscale)), 90.0, arg0, $00, $02, $00, "", $00)
            local0\Field21 = $00
            local0\Field4 = $01
            positionentity(local0\Field3[$00], entityx(local0\Field3[$00], $01), entityy(local0\Field3[$00], $01), (entityz(local0\Field3[$00], $01) - 0.1), $01)
            positionentity(local0\Field3[$01], entityx(local0\Field3[$01], $01), entityy(local0\Field3[$01], $01), (entityz(local0\Field3[$01], $01) + 0.1), $01)
            arg0\Field19[$00] = createpivot($00)
            positionentity(arg0\Field19[$00], (arg0\Field3 + (490.0 * roomscale)), (arg0\Field4 - (400.0 * roomscale)), arg0\Field5, $00)
            entityparent(arg0\Field19[$00], arg0\Field2, $01)
            arg0\Field19[$01] = createpivot($00)
            positionentity(arg0\Field19[$01], arg0\Field3, (arg0\Field4 + (850.0 * roomscale)), arg0\Field5, $00)
            entityparent(arg0\Field19[$01], arg0\Field2, $01)
            arg0\Field19[$02] = createpivot($00)
            positionentity(arg0\Field19[$02], (arg0\Field3 - (540.0 * roomscale)), arg0\Field4, arg0\Field5, $00)
            entityparent(arg0\Field19[$02], arg0\Field2, $01)
            entitypickmode(arg0\Field19[$02], $01, $01)
            local6 = createitem("Document SCP-009", "paper", (arg0\Field3 + (206.0 * roomscale)), (arg0\Field4 + (178.0 * roomscale)), (arg0\Field5 + (422.0 * roomscale)), $00, $00, $00, 1.0, $00)
            entityparent(local6\Field1, arg0\Field2, $01)
        Case "room096"
            local0 = createdoor(arg0\Field0, (arg0\Field3 - (320.0 * roomscale)), arg0\Field4, (arg0\Field5 + (320.0 * roomscale)), 90.0, arg0, $00, $00, $05, "", $00)
            local0\Field21 = $00
            positionentity(local0\Field3[$00], entityx(local0\Field3[$00], $01), entityy(local0\Field3[$00], $01), entityz(local0\Field3[$00], $01), $01)
            positionentity(local0\Field3[$01], entityx(local0\Field3[$01], $01), entityy(local0\Field3[$01], $01), entityz(local0\Field3[$01], $01), $01)
            local0 = createdoor(arg0\Field0, arg0\Field3, arg0\Field4, arg0\Field5, 0.0, arg0, $00, $00, $05, "", $00)
            local0\Field21 = $00
            positionentity(local0\Field3[$00], entityx(local0\Field3[$00], $01), entityy(local0\Field3[$00], $01), entityz(local0\Field3[$00], $01), $01)
            positionentity(local0\Field3[$01], entityx(local0\Field3[$01], $01), entityy(local0\Field3[$01], $01), entityz(local0\Field3[$01], $01), $01)
            arg0\Field21[$00] = createdoor(arg0\Field0, (arg0\Field3 - (385.0 * roomscale)), arg0\Field4, (arg0\Field5 - (512.0 * roomscale)), 90.0, arg0, $01, $00, $05, "", $00)
            arg0\Field21[$00]\Field21 = $00
            positionentity(arg0\Field21[$00]\Field3[$00], entityx(arg0\Field21[$00]\Field3[$00], $01), entityy(arg0\Field21[$00]\Field3[$00], $01), entityz(arg0\Field21[$00]\Field3[$00], $01), $01)
            positionentity(arg0\Field21[$00]\Field3[$01], entityx(arg0\Field21[$00]\Field3[$01], $01), entityy(arg0\Field21[$00]\Field3[$01], $01), entityz(arg0\Field21[$00]\Field3[$01], $01), $01)
            arg0\Field19[$00] = createpivot($00)
            positionentity(arg0\Field19[$00], (arg0\Field3 - (510.0 * roomscale)), (arg0\Field4 + (200.0 * roomscale)), (arg0\Field5 - (512.0 * roomscale)), $00)
            entityparent(arg0\Field19[$00], arg0\Field2, $01)
            arg0\Field19[$01] = createpivot($00)
            positionentity(arg0\Field19[$01], (arg0\Field3 - (466.0 * roomscale)), (arg0\Field4 + 0.004), (arg0\Field5 - (535.0 * roomscale)), $00)
            entityparent(arg0\Field19[$01], arg0\Field2, $01)
            arg0\Field19[$02] = createpivot($00)
            positionentity(arg0\Field19[$02], (arg0\Field3 - (477.0 * roomscale)), (arg0\Field4 + (240.0 * roomscale)), (arg0\Field5 - (710.0 * roomscale)), $00)
            entityparent(arg0\Field19[$02], arg0\Field2, $01)
            arg0\Field19[$03] = createpivot($00)
            positionentity(arg0\Field19[$03], (arg0\Field3 - (1000.0 * roomscale)), (arg0\Field4 + (200.0 * roomscale)), (arg0\Field5 - (512.0 * roomscale)), $00)
            entityparent(arg0\Field19[$03], arg0\Field2, $01)
            arg0\Field19[$04] = createpivot($00)
            positionentity(arg0\Field19[$04], (arg0\Field3 - (555.0 * roomscale)), (arg0\Field4 + (240.0 * roomscale)), (arg0\Field5 - (666.0 * roomscale)), $00)
            entityparent(arg0\Field19[$04], arg0\Field2, $01)
            local3 = createdecal($03, (arg0\Field3 - (870.0 * roomscale)), (arg0\Field4 + 0.004), (arg0\Field5 + (369.0 * roomscale)), 90.0, rnd(360.0, 0.0), 0.0)
            local3\Field2 = 0.5
            scalesprite(local3\Field0, local3\Field2, local3\Field2)
            entityparent(local3\Field0, arg0\Field2, $01)
            local6 = createitem("Data Report", "paper", (arg0\Field3 - (860.0 * roomscale)), (arg0\Field4 + (240.0 * roomscale)), (arg0\Field5 + (80.0 * roomscale)), $00, $00, $00, 1.0, $00)
            entityparent(local6\Field1, arg0\Field2, $01)
            rotateentity(local6\Field1, 0.0, 90.0, 0.0, $00)
            local6 = createitem("Severed Hand", "hand3", (arg0\Field3 - (860.0 * roomscale)), (arg0\Field4 + (180.0 * roomscale)), (arg0\Field5 + (369.0 * roomscale)), $00, $00, $00, 1.0, $00)
            entityparent(local6\Field1, arg0\Field2, $01)
            local6 = createitem("9V Battery", "bat", (arg0\Field3 - (514.0 * roomscale)), (arg0\Field4 + (150.0 * roomscale)), (arg0\Field5 + (63.0 * roomscale)), $00, $00, $00, 1.0, $00)
            entityparent(local6\Field1, arg0\Field2, $01)
            local6 = createitem("Document SCP-096", "paper", (arg0\Field3 - (500.0 * roomscale)), (arg0\Field4 + (220.0 * roomscale)), (arg0\Field5 + (63.0 * roomscale)), $00, $00, $00, 1.0, $00)
            entityparent(local6\Field1, arg0\Field2, $01)
            rotateentity(local6\Field1, 0.0, 90.0, 0.0, $00)
        Case "room409"
            arg0\Field19[$00] = createpivot($00)
            positionentity(arg0\Field19[$00], (arg0\Field3 - (4951.0 * roomscale)), (arg0\Field4 - (4763.0 * roomscale)), (arg0\Field5 + (1828.0 * roomscale)), $00)
            entityparent(arg0\Field19[$00], arg0\Field2, $01)
            arg0\Field19[$01] = createpivot($00)
            positionentity(arg0\Field19[$01], (arg0\Field3 + (552.0 * roomscale)), (arg0\Field4 + (240.0 * roomscale)), (arg0\Field5 + (656.0 * roomscale)), $00)
            entityparent(arg0\Field19[$01], arg0\Field2, $01)
            arg0\Field19[$02] = createpivot($00)
            positionentity(arg0\Field19[$02], (arg0\Field3 - (4951.0 * roomscale)), (arg0\Field4 - (4763.0 * roomscale)), (arg0\Field5 + (1692.0 * roomscale)), $00)
            entityparent(arg0\Field19[$02], arg0\Field2, $01)
            arg0\Field19[$03] = createpivot($00)
            positionentity(arg0\Field19[$03], (arg0\Field3 - (2040.0 * roomscale)), (arg0\Field4 - (4283.0 * roomscale)), (arg0\Field5 - (656.0 * roomscale)), $00)
            entityparent(arg0\Field19[$03], arg0\Field2, $01)
            arg0\Field19[$04] = createpivot($00)
            positionentity(arg0\Field19[$04], (arg0\Field3 - (4885.0 * roomscale)), (arg0\Field4 - (4598.0 * roomscale)), (arg0\Field5 + (2235.0 * roomscale)), $00)
            entityparent(arg0\Field19[$04], arg0\Field2, $01)
            arg0\Field21[$02] = createdoor(arg0\Field0, (arg0\Field3 - (4336.0 * roomscale)), (arg0\Field4 - (4528.0 * roomscale)), (arg0\Field5 + (1552.0 * roomscale)), 0.0, arg0, $00, $00, $06, "", $00)
            arg0\Field21[$02]\Field21 = $00
            positionentity(arg0\Field21[$02]\Field3[$00], entityx(arg0\Field21[$02]\Field3[$00], $01), entityy(arg0\Field21[$02]\Field3[$01], $01), (entityz(arg0\Field21[$02]\Field3[$00], $01) + 0.061), $01)
            positionentity(arg0\Field21[$02]\Field3[$01], entityx(arg0\Field21[$02]\Field3[$01], $01), entityy(arg0\Field21[$02]\Field3[$01], $01), (entityz(arg0\Field21[$02]\Field3[$01], $01) - 0.061), $01)
            If ((((chancetospawn005 = $03) And ((chancetospawn005 = $01) = $00)) And ((chancetospawn005 = $02) = $00)) <> 0) Then
                local6 = createitem("SCP-005", "scp005", (arg0\Field3 - (4951.0 * roomscale)), (arg0\Field4 - (4688.0 * roomscale)), (arg0\Field5 + (1828.0 * roomscale)), $00, $00, $00, 1.0, $00)
                entityparent(local6\Field1, arg0\Field2, $01)
            EndIf
            local6 = createitem("Document SCP-409", "paper", (arg0\Field3 - (3595.0 * roomscale)), (arg0\Field4 - (4608.0 * roomscale)), (arg0\Field5 + (2234.0 * roomscale)), $00, $00, $00, 1.0, $00)
            entityparent(local6\Field1, arg0\Field2, $01)
            rotateentity(local6\Field1, 0.0, 0.0, 0.0, $00)
            arg0\Field21[$00] = createdoor(arg0\Field0, (arg0\Field3 + (264.0 * roomscale)), arg0\Field4, (arg0\Field5 + (655.0 * roomscale)), 90.0, arg0, $01, $03, $00, "", $00)
            arg0\Field21[$00]\Field21 = $00
            arg0\Field21[$00]\Field5 = $01
            positionentity(arg0\Field21[$00]\Field3[$00], (entityx(arg0\Field21[$00]\Field3[$00], $01) + 0.031), entityy(arg0\Field21[$00]\Field3[$00], $01), entityz(arg0\Field21[$00]\Field3[$00], $01), $01)
            positionentity(arg0\Field21[$00]\Field3[$01], (entityx(arg0\Field21[$00]\Field3[$01], $01) - 0.031), entityy(arg0\Field21[$00]\Field3[$01], $01), entityz(arg0\Field21[$00]\Field3[$01], $01), $01)
            arg0\Field21[$01] = createdoor(arg0\Field0, (arg0\Field3 - (2328.0 * roomscale)), (arg0\Field4 - (4528.0 * roomscale)), (arg0\Field5 - (656.0 * roomscale)), 90.0, arg0, $00, $03, $00, "", $00)
            arg0\Field21[$01]\Field21 = $00
            arg0\Field21[$01]\Field5 = $00
            positionentity(arg0\Field21[$01]\Field3[$00], (entityx(arg0\Field21[$01]\Field3[$00], $01) + 0.031), entityy(arg0\Field21[$01]\Field3[$01], $01), entityz(arg0\Field21[$01]\Field3[$00], $01), $01)
            positionentity(arg0\Field21[$01]\Field3[$01], (entityx(arg0\Field21[$01]\Field3[$01], $01) - 0.031), entityy(arg0\Field21[$01]\Field3[$01], $01), entityz(arg0\Field21[$01]\Field3[$01], $01), $01)
            local2 = createsecuritycam((arg0\Field3 - (3624.0 * roomscale)), (arg0\Field4 - (4112.0 * roomscale)), (arg0\Field5 + (2248.0 * roomscale)), arg0, $00)
            local2\Field11 = 100.0
            local2\Field12 = 45.0
            turnentity(local2\Field3, 20.0, 0.0, 0.0, $00)
            entityparent(local2\Field0, arg0\Field2, $01)
        Case "room2scps3"
            local0 = createdoor(arg0\Field0, (arg0\Field3 + (272.0 * roomscale)), arg0\Field4, arg0\Field5, 90.0, arg0, $00, $00, $05, "", $00)
            local0\Field21 = $00
            positionentity(local0\Field3[$00], (entityx(local0\Field3[$00], $01) + 0.061), entityy(local0\Field3[$00], $01), entityz(local0\Field3[$00], $01), $01)
            positionentity(local0\Field3[$01], (entityx(local0\Field3[$01], $01) - 0.061), entityy(local0\Field3[$01], $01), entityz(local0\Field3[$01], $01), $01)
            local0 = createdoor(arg0\Field0, (arg0\Field3 - (264.0 * roomscale)), arg0\Field4, (arg0\Field5 + (32.0 * roomscale)), 270.0, arg0, $00, $00, $05, "", $00)
            local0\Field21 = $00
            positionentity(local0\Field3[$00], (entityx(local0\Field3[$00], $01) - 0.031), entityy(local0\Field3[$00], $01), entityz(local0\Field3[$00], $01), $01)
            positionentity(local0\Field3[$01], (entityx(local0\Field3[$01], $01) + 0.031), entityy(local0\Field3[$01], $01), entityz(local0\Field3[$01], $01), $01)
            local0 = createdoor(arg0\Field0, (arg0\Field3 + (560.0 * roomscale)), arg0\Field4, (arg0\Field5 + (272.0 * roomscale)), 180.0, arg0, $00, $00, $05, "", $00)
            local0\Field21 = $00
            local0 = createdoor(arg0\Field0, (arg0\Field3 + (560.0 * roomscale)), arg0\Field4, (arg0\Field5 - (272.0 * roomscale)), 0.0, arg0, $00, $00, $05, "", $00)
            local0\Field21 = $00
            local0 = createdoor(arg0\Field0, (arg0\Field3 + (880.0 * roomscale)), arg0\Field4, arg0\Field5, 270.0, arg0, $00, $00, $06, "", $00)
            local0\Field21 = $00
            local0 = createdoor(arg0\Field0, (arg0\Field3 - (640.0 * roomscale)), arg0\Field4, (arg0\Field5 - (128.0 * roomscale)), 270.0, arg0, $00, $00, $05, "", $00)
            local0\Field21 = $00
            positionentity(local0\Field3[$00], (entityx(local0\Field3[$00], $01) + 0.061), entityy(local0\Field3[$00], $01), entityz(local0\Field3[$00], $01), $01)
            positionentity(local0\Field3[$01], (entityx(local0\Field3[$01], $01) - 0.061), entityy(local0\Field3[$01], $01), entityz(local0\Field3[$01], $01), $01)
            local0 = createdoor(arg0\Field0, (arg0\Field3 - (640.0 * roomscale)), arg0\Field4, (arg0\Field5 + (352.0 * roomscale)), 270.0, arg0, $00, $00, $05, "", $00)
            local0\Field21 = $00
            positionentity(local0\Field3[$00], (entityx(local0\Field3[$00], $01) + 0.061), entityy(local0\Field3[$00], $01), entityz(local0\Field3[$00], $01), $01)
            positionentity(local0\Field3[$01], (entityx(local0\Field3[$01], $01) - 0.061), entityy(local0\Field3[$01], $01), entityz(local0\Field3[$01], $01), $01)
            local6 = createitem("SCP-198", "scp198", (arg0\Field3 + (812.0 * roomscale)), (arg0\Field4 + (210.0 * roomscale)), (arg0\Field5 + (900.0 * roomscale)), $00, $00, $00, 1.0, $00)
            entityparent(local6\Field1, arg0\Field2, $01)
            local6 = createitem("SCP-109", "scp109", (arg0\Field3 + (1207.0 * roomscale)), (arg0\Field4 + (285.0 * roomscale)), (arg0\Field5 + (2.0 * roomscale)), $00, $00, $00, 1.0, $00)
            entityparent(local6\Field1, arg0\Field2, $01)
            rotateentity(local6\Field1, 0.0, 90.0, 0.0, $00)
            setanimtime(local6\Field2, 0.0, $00)
            local6 = createitem("SCP-178", "scp178", (arg0\Field3 - (1240.0 * roomscale)), (240.0 * roomscale), (arg0\Field5 - (128.0 * roomscale)), $00, $00, $00, 1.0, $00)
            entityparent(local6\Field1, arg0\Field2, $01)
            rotateentity(local6\Field1, 0.0, 90.0, 0.0, $00)
            setanimtime(local6\Field2, 0.0, $00)
            local6 = createitem("Glasses Case", "glassescase", (arg0\Field3 + (569.0 * roomscale)), (arg0\Field4 + (290.0 * roomscale)), (arg0\Field5 - (747.0 * roomscale)), $00, $00, $00, 1.0, $00)
            entityparent(local6\Field1, arg0\Field2, $01)
            rotateentity(local6\Field1, 0.0, -180.0, 0.0, $00)
            setanimtime(local6\Field2, 14.0, $00)
            local6 = createitem("Document SCP-215", "paper", (arg0\Field3 + (385.0 * roomscale)), (arg0\Field4 + (290.0 * roomscale)), (arg0\Field5 - (370.0 * roomscale)), $00, $00, $00, 1.0, $00)
            entityparent(local6\Field1, arg0\Field2, $01)
            rotateentity(local6\Field1, 0.0, 0.0, 0.0, $00)
            local6 = createitem("Document SCP-198", "paper", (arg0\Field3 + (1242.0 * roomscale)), (arg0\Field4 + (290.0 * roomscale)), (arg0\Field5 + (360.0 * roomscale)), $00, $00, $00, 1.0, $00)
            entityparent(local6\Field1, arg0\Field2, $01)
            rotateentity(local6\Field1, 0.0, 0.0, 0.0, $00)
            local6 = createitem("Document SCP-178", "paper", (arg0\Field3 - (1260.0 * roomscale)), (arg0\Field4 + (250.0 * roomscale)), (arg0\Field5 + (352.0 * roomscale)), $00, $00, $00, 1.0, $00)
            entityparent(local6\Field1, arg0\Field2, $01)
            rotateentity(local6\Field1, 0.0, 0.0, 0.0, $00)
            local6 = createitem("Document SCP-109", "paper", (arg0\Field3 + (966.0 * roomscale)), (arg0\Field4 + (290.0 * roomscale)), (arg0\Field5 - (187.0 * roomscale)), $00, $00, $00, 1.0, $00)
            entityparent(local6\Field1, arg0\Field2, $01)
            rotateentity(local6\Field1, 0.0, 0.0, 0.0, $00)
            For local7 = $00 To $03 Step $01
                Select local7
                    Case $00
                        local33 = 560.0
                        local34 = 360.0
                        local35 = 386.0
                        local36 = 0.0
                    Case $01
                        local33 = 560.0
                        local34 = -360.0
                        local35 = 386.0
                        local36 = 180.0
                    Case $02
                        local33 = 981.0
                        local34 = 0.0
                        local35 = 386.0
                        local36 = -90.0
                    Case $03
                        local33 = -740.0
                        local34 = -128.0
                        local35 = 415.0
                        local36 = 90.0
                End Select
                local2 = createsecuritycam((arg0\Field3 + (local33 * roomscale)), (arg0\Field4 + (local35 * roomscale)), (arg0\Field5 + (local34 * roomscale)), arg0, $00)
                local2\Field11 = local36
                local2\Field12 = 30.0
                turnentity(local2\Field3, 30.0, 0.0, 0.0, $00)
                entityparent(local2\Field0, arg0\Field2, $01)
            Next
        Case "room005"
            If ((((chancetospawn005 = $01) And ((chancetospawn005 = $02) = $00)) And ((chancetospawn005 = $03) = $00)) <> 0) Then
                local6 = createitem("SCP-005", "scp005", arg0\Field3, (arg0\Field4 + (254.0 * roomscale)), (arg0\Field5 - (260.0 * roomscale)), $00, $00, $00, 1.0, $00)
                entityparent(local6\Field1, arg0\Field2, $01)
            ElseIf ((((chancetospawn005 = $02) And ((chancetospawn005 = $01) = $00)) And ((chancetospawn005 = $03) = $00)) <> 0) Then
                local6 = createitem("Note from Maynard", "paper", arg0\Field3, (arg0\Field4 + (254.0 * roomscale)), (arg0\Field5 - (260.0 * roomscale)), $00, $00, $00, 1.0, $00)
                entityparent(local6\Field1, arg0\Field2, $01)
            EndIf
            arg0\Field19[$00] = createpivot($00)
            positionentity(arg0\Field19[$00], arg0\Field3, (arg0\Field4 + (76.0 * roomscale)), (arg0\Field5 - (260.0 * roomscale)), $00)
            arg0\Field19[$01] = createpivot($00)
            positionentity(arg0\Field19[$01], arg0\Field3, (arg0\Field4 + (188.0 * roomscale)), (arg0\Field5 - (25.0 * roomscale)), $00)
            arg0\Field19[$02] = createpivot($00)
            positionentity(arg0\Field19[$02], arg0\Field3, (arg0\Field4 + (12.0 * roomscale)), (arg0\Field5 + (55.0 * roomscale)), $00)
            For local7 = $00 To $02 Step $01
                entityparent(arg0\Field19[local7], arg0\Field2, $01)
            Next
            local6 = createitem("Document SCP-005", "paper", (arg0\Field3 + (338.0 * roomscale)), (arg0\Field4 + (152.0 * roomscale)), (arg0\Field5 - (500.0 * roomscale)), $00, $00, $00, 1.0, $00)
            entityparent(local6\Field1, arg0\Field2, $01)
            local0 = createdoor(arg0\Field0, arg0\Field3, arg0\Field4, (arg0\Field5 - (672.0 * roomscale)), 0.0, arg0, $00, $00, $06, "", $00)
            local0\Field21 = $00
            positionentity(local0\Field3[$00], entityx(local0\Field3[$00], $01), entityy(local0\Field3[$00], $01), (entityz(local0\Field3[$00], $01) + 0.061), $01)
            positionentity(local0\Field3[$01], entityx(local0\Field3[$01], $01), entityy(local0\Field3[$01], $01), (entityz(local0\Field3[$01], $01) - 0.061), $01)
            local2 = createsecuritycam(arg0\Field3, (arg0\Field4 + (415.0 * roomscale)), (arg0\Field5 - (572.0 * roomscale)), arg0, $00)
            local2\Field11 = 0.0
            local2\Field12 = 30.0
            turnentity(local2\Field3, 30.0, 0.0, 0.0, $00)
            entityparent(local2\Field0, arg0\Field2, $01)
        Case "room447"
            local0 = createdoor(arg0\Field0, (arg0\Field3 - (352.0 * roomscale)), arg0\Field4, (arg0\Field5 + (576.0 * roomscale)), 90.0, arg0, $00, $00, $05, "", $00)
            local0\Field21 = $00
            local0 = createdoor(arg0\Field0, (arg0\Field3 - (1376.0 * roomscale)), arg0\Field4, (arg0\Field5 + (576.0 * roomscale)), 90.0, arg0, $00, $00, $05, "", $00)
            local0\Field21 = $00
            local0 = createdoor(arg0\Field0, (arg0\Field3 - (895.0 * roomscale)), arg0\Field4, (arg0\Field5 + (256.0 * roomscale)), 180.0, arg0, $00, $00, $05, "", $00)
            local0\Field21 = $00
            local6 = createitem("SCP-447", "scp447", (arg0\Field3 - (995.0 * roomscale)), (arg0\Field4 + (8.0 * roomscale)), (arg0\Field5 - (146.0 * roomscale)), $00, $00, $00, 1.0, $00)
            entityparent(local6\Field1, arg0\Field2, $01)
            local6 = createitem("Document SCP-447", "paper", (arg0\Field3 - (1880.0 * roomscale)), (arg0\Field4 + (200.0 * roomscale)), (arg0\Field5 + (126.0 * roomscale)), $00, $00, $00, 1.0, $00)
            entityparent(local6\Field1, arg0\Field2, $01)
            local3 = createdecal($07, (arg0\Field3 - (995.0 * roomscale)), (arg0\Field4 + 0.004), (arg0\Field5 - (146.0 * roomscale)), 90.0, (Float rand($168, $01)), 0.0)
            local3\Field2 = 0.2
            entityalpha(local3\Field0, 0.6)
            scalesprite(local3\Field0, local3\Field2, local3\Field2)
            entityparent(local3\Field0, arg0\Field2, $01)
        Case "room3scps"
            arg0\Field21[$00] = createdoor(arg0\Field0, (arg0\Field3 + (257.0 * roomscale)), arg0\Field4, (arg0\Field5 - (670.0 * roomscale)), 90.0, arg0, $00, $00, $05, "", $00)
            arg0\Field21[$00]\Field4 = $01
            arg0\Field21[$00]\Field21 = $00
            arg0\Field21[$00]\Field24 = $00
            local0 = createdoor(arg0\Field0, (arg0\Field3 - (256.0 * roomscale)), arg0\Field4, (arg0\Field5 - (672.0 * roomscale)), 90.0, arg0, $00, $00, $05, "", $00)
            local0\Field21 = $00
            local0 = createdoor(arg0\Field0, (arg0\Field3 + (240.0 * roomscale)), arg0\Field4, (arg0\Field5 + (577.0 * roomscale)), 90.0, arg0, $00, $00, $05, "", $00)
            local0\Field21 = $00
            positionentity(local0\Field3[$00], (entityx(local0\Field3[$00], $01) - 0.061), entityy(local0\Field3[$00], $01), entityz(local0\Field3[$00], $01), $01)
            positionentity(local0\Field3[$01], (entityx(local0\Field3[$01], $01) + 0.061), entityy(local0\Field3[$01], $01), entityz(local0\Field3[$01], $01), $01)
            local0 = createdoor(arg0\Field0, (arg0\Field3 - (272.0 * roomscale)), arg0\Field4, (arg0\Field5 + (577.0 * roomscale)), 90.0, arg0, $00, $00, $05, "", $00)
            local0\Field21 = $00
            positionentity(local0\Field3[$00], (entityx(local0\Field3[$00], $01) - 0.061), entityy(local0\Field3[$00], $01), entityz(local0\Field3[$00], $01), $01)
            positionentity(local0\Field3[$01], (entityx(local0\Field3[$01], $01) + 0.061), entityy(local0\Field3[$01], $01), entityz(local0\Field3[$01], $01), $01)
            local0 = createdoor(arg0\Field0, arg0\Field3, arg0\Field4, (arg0\Field5 + (256.0 * roomscale)), 0.0, arg0, $00, $00, $05, "", $00)
            local0\Field21 = $00
            local0 = createdoor(arg0\Field0, (arg0\Field3 - (15.5 * roomscale)), arg0\Field4, (arg0\Field5 + (848.0 * roomscale)), 0.0, arg0, $00, $00, $06, "", $00)
            local0\Field21 = $00
            positionentity(local0\Field3[$00], entityx(local0\Field3[$00], $01), entityy(local0\Field3[$00], $01), (entityz(local0\Field3[$00], $01) + 0.061), $01)
            positionentity(local0\Field3[$01], entityx(local0\Field3[$01], $01), entityy(local0\Field3[$01], $01), (entityz(local0\Field3[$01], $01) - 0.061), $01)
            For local7 = $00 To $09 Step $01
                Select local7
                    Case $00
                        local28 = 500.0
                        local29 = -600.0
                    Case $01
                        local28 = 433.0
                        local29 = -823.0
                    Case $02
                        local28 = 380.0
                        local29 = -701.0
                    Case $03
                        local28 = 640.0
                        local29 = -625.0
                    Case $04
                        local28 = 540.0
                        local29 = -599.0
                    Case $05
                        local28 = 520.0
                        local29 = -770.0
                    Case $06
                        local28 = 480.0
                        local29 = -570.0
                    Case $07
                        local28 = 582.0
                        local29 = -657.0
                    Case $08
                        local28 = 329.0
                        local29 = -657.0
                    Case $09
                        local28 = 401.0
                        local29 = -620.0
                End Select
                local3 = createdecal((Int rnd(22.0, 23.0)), (arg0\Field3 + (local28 * roomscale)), (arg0\Field4 + 0.005), (arg0\Field5 + (local29 * roomscale)), 90.0, (Float rand($168, $01)), 0.0)
                local3\Field2 = rnd(0.3, 0.0)
                entityalpha(local3\Field0, 1.0)
                scalesprite(local3\Field0, local3\Field2, local3\Field2)
                entityparent(local3\Field0, arg0\Field2, $01)
            Next
            For local7 = $00 To $03 Step $01
                Select local7
                    Case $00
                        local63 = 672.0
                        local64 = -575.0
                    Case $01
                        local63 = 670.0
                        local64 = -511.0
                    Case $02
                        local63 = 666.0
                        local64 = -801.0
                    Case $03
                        local63 = 656.0
                        local64 = -805.0
                End Select
                local6 = createitem("SCP-1079", "scp1079", (arg0\Field3 + (local63 * roomscale)), (arg0\Field4 + (50.0 * roomscale)), (arg0\Field5 + (local64 * roomscale)), $00, $00, $00, 1.0, $00)
                entityparent(local6\Field1, arg0\Field2, $01)
                rotateentity(local6\Field1, 0.0, (Float rand($168, $01)), 0.0, $00)
            Next
            local6 = createitem("Document SCP-1079", "paper", (arg0\Field3 + (420.0 * roomscale)), (arg0\Field4 + (250.0 * roomscale)), (arg0\Field5 - (476.0 * roomscale)), $00, $00, $00, 1.0, $00)
            entityparent(local6\Field1, arg0\Field2, $01)
            rotateentity(local6\Field1, 0.0, 90.0, 0.0, $00)
            local6 = createitem("SCP-357", "scp357", (arg0\Field3 - (512.0 * roomscale)), (arg0\Field4 + (200.0 * roomscale)), (arg0\Field5 - (640.0 * roomscale)), $00, $00, $00, 1.0, $00)
            entityparent(local6\Field1, arg0\Field2, $01)
            local6 = createitem("SCP-1033-RU", "scp1033ru", arg0\Field3, (arg0\Field4 + (30.0 * roomscale)), (arg0\Field5 + (1278.0 * roomscale)), $00, $00, $00, 1.0, $00)
            entityparent(local6\Field1, arg0\Field2, $01)
            local6 = createitem("SCP-402", "scp402", (arg0\Field3 + (676.0 * roomscale)), (arg0\Field4 + (150.0 * roomscale)), (arg0\Field5 + (577.0 * roomscale)), $00, $00, $00, 1.0, $00)
            entityparent(local6\Field1, arg0\Field2, $01)
            local6 = createitem("SCP-207", "scp207", (arg0\Field3 - (676.0 * roomscale)), (arg0\Field4 + (20.0 * roomscale)), (arg0\Field5 + (577.0 * roomscale)), $00, $00, $00, 1.0, $00)
            entityparent(local6\Field1, arg0\Field2, $01)
            rotateentity(local6\Field1, 0.0, 95.0, 0.0, $00)
            local6 = createitem("Document SCP-357", "paper", (arg0\Field3 - (706.0 * roomscale)), (arg0\Field4 + (250.0 * roomscale)), (arg0\Field5 - (759.0 * roomscale)), $00, $00, $00, 1.0, $00)
            entityparent(local6\Field1, arg0\Field2, $01)
            rotateentity(local6\Field1, 0.0, 0.0, 0.0, $00)
            local6 = createitem("Document SCP-1033-RU", "paper", (arg0\Field3 + (165.0 * roomscale)), (arg0\Field4 + (210.0 * roomscale)), (arg0\Field5 + (945.0 * roomscale)), $00, $00, $00, 1.0, $00)
            entityparent(local6\Field1, arg0\Field2, $01)
            rotateentity(local6\Field1, 0.0, 0.0, 0.0, $00)
            local6 = createitem("Document SCP-207", "paper", (arg0\Field3 - (716.0 * roomscale)), (arg0\Field4 + (210.0 * roomscale)), (arg0\Field5 + (577.0 * roomscale)), $00, $00, $00, 1.0, $00)
            entityparent(local6\Field1, arg0\Field2, $01)
            rotateentity(local6\Field1, 0.0, 0.0, 0.0, $00)
            local6 = createitem("Document SCP-402", "paper", (arg0\Field3 + (330.0 * roomscale)), (arg0\Field4 + (250.0 * roomscale)), (arg0\Field5 + (377.0 * roomscale)), $00, $00, $00, 1.0, $00)
            entityparent(local6\Field1, arg0\Field2, $01)
            rotateentity(local6\Field1, 0.0, 90.0, 0.0, $00)
            arg0\Field19[$00] = createpivot($00)
            positionentity(arg0\Field19[$00], (arg0\Field3 + (433.0 * roomscale)), arg0\Field4, (arg0\Field5 - (823.0 * roomscale)), $00)
            entityparent(arg0\Field19[$00], arg0\Field2, $01)
            For local7 = $00 To $04 Step $01
                Select local7
                    Case $00
                        local33 = 356.0
                        local34 = -670.0
                        local36 = -90.0
                    Case $01
                        local33 = -356.0
                        local34 = -670.0
                        local36 = 90.0
                    Case $02
                        local33 = -372.0
                        local34 = 577.0
                        local36 = 90.0
                    Case $03
                        local33 = 340.0
                        local34 = 577.0
                        local36 = -90.0
                    Case $04
                        local33 = -15.5
                        local34 = 948.0
                        local36 = 0.0
                End Select
                local2 = createsecuritycam((arg0\Field3 + (local33 * roomscale)), (arg0\Field4 + (386.0 * roomscale)), (arg0\Field5 + (local34 * roomscale)), arg0, $00)
                local2\Field11 = local36
                local2\Field12 = 30.0
                turnentity(local2\Field3, 30.0, 0.0, 0.0, $00)
                entityparent(local2\Field0, arg0\Field2, $01)
            Next
        Case "room066"
            arg0\Field19[$00] = createpivot($00)
            positionentity(arg0\Field19[$00], (arg0\Field3 - (265.0 * roomscale)), arg0\Field4, (arg0\Field5 + (85.0 * roomscale)), $00)
            entityparent(arg0\Field19[$00], arg0\Field2, $01)
            arg0\Field19[$01] = createpivot($00)
            positionentity(arg0\Field19[$01], (arg0\Field3 - (593.0 * roomscale)), (arg0\Field4 + (200.0 * roomscale)), (arg0\Field5 - (265.0 * roomscale)), $00)
            entityparent(arg0\Field19[$01], arg0\Field2, $01)
            arg0\Field21[$00] = createdoor(arg0\Field0, (arg0\Field3 - (268.0 * roomscale)), arg0\Field4, arg0\Field5, 90.0, arg0, $00, $00, $05, "", $00)
            arg0\Field21[$00]\Field4 = $01
            arg0\Field21[$00]\Field21 = $00
            positionentity(arg0\Field21[$00]\Field3[$00], (entityx(arg0\Field21[$00]\Field3[$00], $01) + 0.015), entityy(arg0\Field21[$00]\Field3[$00], $01), entityz(arg0\Field21[$00]\Field3[$00], $01), $01)
            positionentity(arg0\Field21[$00]\Field3[$01], (entityx(arg0\Field21[$00]\Field3[$01], $01) - 0.015), entityy(arg0\Field21[$00]\Field3[$01], $01), entityz(arg0\Field21[$00]\Field3[$01], $01), $01)
            local6 = createitem("Level 1 Key Card", "key1", (arg0\Field3 - (560.0 * roomscale)), (arg0\Field4 + (200.0 * roomscale)), (arg0\Field5 + (156.0 * roomscale)), $00, $00, $00, 1.0, $00)
            entityparent(local6\Field1, arg0\Field2, $01)
            rotateentity(local6\Field1, 0.0, 0.0, 0.0, $00)
        Case "room2bio"
            If (arg0\Field19[$01] = $00) Then
                arg0\Field19[$01] = loadmesh_strict(scpmodding_processfilepath("GFX\map\room2bio_terrain.b3d"), $00)
            EndIf
            scaleentity(arg0\Field19[$01], roomscale, roomscale, roomscale, $00)
            rotateentity(arg0\Field19[$01], 0.0, (Float arg0\Field6), 0.0, $00)
            positionentity(arg0\Field19[$01], arg0\Field3, (arg0\Field4 - (1.0 * roomscale)), arg0\Field5, $00)
            entityparent(arg0\Field19[$01], arg0\Field2, $01)
            local2 = createsecuritycam((arg0\Field3 - (475.0 * roomscale)), (arg0\Field4 + (385.0 * roomscale)), (arg0\Field5 + (305.0 * roomscale)), arg0, $00)
            local2\Field11 = 225.0
            local2\Field12 = 45.0
            turnentity(local2\Field3, 20.0, 0.0, 0.0, $00)
        Case "room2offices5"
            local6 = createitem("Incident O5-14", "paper", (arg0\Field3 + (400.0 * roomscale)), (arg0\Field4 + (230.0 * roomscale)), (arg0\Field5 + (960.0 * roomscale)), $00, $00, $00, 1.0, $00)
            entityparent(local6\Field1, arg0\Field2, $01)
            rotateentity(local6\Field1, 0.0, 90.0, 0.0, $00)
            If (arg0\Field19[$00] = $00) Then
                arg0\Field19[$00] = loadmesh_strict(scpmodding_processfilepath("GFX\map\room2offices5_hb.b3d"), arg0\Field2)
            EndIf
            entitypickmode(arg0\Field19[$00], $02, $01)
            entitytype(arg0\Field19[$00], $01, $00)
            entityalpha(arg0\Field19[$00], 0.0)
        Case "room3offices2"
            If (arg0\Field19[$00] = $00) Then
                arg0\Field19[$00] = loadmesh_strict(scpmodding_processfilepath("GFX\map\room3offices2_hb.b3d"), arg0\Field2)
            EndIf
            entitypickmode(arg0\Field19[$00], $02, $01)
            entitytype(arg0\Field19[$00], $01, $00)
            entityalpha(arg0\Field19[$00], 0.0)
        Case "room2coffices"
            For local4 = Each rooms
                If (((local4\Field7\Field10 = arg0\Field7\Field10) And (local4 <> arg0)) <> 0) Then
                    arg0\Field19[$00] = copyentity(local4\Field19[$00], arg0\Field2)
                    Exit
                EndIf
            Next
            If (arg0\Field19[$00] = $00) Then
                arg0\Field19[$00] = loadmesh_strict(scpmodding_processfilepath("GFX\map\room2Coffices_hb.b3d"), arg0\Field2)
            EndIf
            entitypickmode(arg0\Field19[$00], $02, $01)
            entitytype(arg0\Field19[$00], $01, $00)
            entityalpha(arg0\Field19[$00], 0.0)
    End Select
    For local67 = Each lighttemplates
        If (local67\Field0 = arg0\Field7) Then
            local68 = addlight(arg0, (arg0\Field3 + local67\Field2), (arg0\Field4 + local67\Field3), (arg0\Field5 + local67\Field4), local67\Field1, local67\Field5, local67\Field6, local67\Field7, local67\Field8)
            If (local68 <> $00) Then
                If (local67\Field1 = $03) Then
                    lightconeangles(local68, (Float local67\Field11), local67\Field12)
                    rotateentity(local68, local67\Field9, local67\Field10, 0.0, $00)
                EndIf
            EndIf
        EndIf
    Next
    For local69 = Each tempscreens
        If (local69\Field4 = arg0\Field7) Then
            createscreen((arg0\Field3 + local69\Field1), (arg0\Field4 + local69\Field2), (arg0\Field5 + local69\Field3), local69\Field0, arg0)
        EndIf
    Next
    For local70 = Each tempwaypoints
        If (local70\Field3 = arg0\Field7) Then
            createwaypoint((arg0\Field3 + local70\Field0), (arg0\Field4 + local70\Field1), (arg0\Field5 + local70\Field2), Null, arg0)
        EndIf
    Next
    If (arg0\Field7\Field14 > $00) Then
        arg0\Field36 = arg0\Field7\Field14
        For local7 = $00 To (arg0\Field36 - $01) Step $01
            arg0\Field37[local7] = copyentity(arg0\Field7\Field15[local7], arg0\Field2)
            arg0\Field38[local7] = arg0\Field7\Field16[local7]
        Next
    EndIf
    For local7 = $00 To $07 Step $01
        If (arg0\Field7\Field4[local7] <> $00) Then
            arg0\Field13[local7] = createpivot(arg0\Field2)
            positionentity(arg0\Field13[local7], (arg0\Field3 + arg0\Field7\Field5[local7]), (arg0\Field4 + arg0\Field7\Field6[local7]), (arg0\Field5 + arg0\Field7\Field7[local7]), $01)
            entityparent(arg0\Field13[local7], arg0\Field2, $01)
            arg0\Field12[local7] = arg0\Field7\Field4[local7]
            arg0\Field14[local7] = arg0\Field7\Field8[local7]
        EndIf
    Next
    Return $00
End Function
